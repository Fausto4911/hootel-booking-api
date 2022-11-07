package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.dao.request.ReserveDAO;
import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.entity.Room;
import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.exception.DurationException;
import com.hotel.booking.bookingapi.exception.NotFoundException;
import com.hotel.booking.bookingapi.exception.ReservationException;
import com.hotel.booking.bookingapi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final HotelService hotelService;

    private final UserService userService;

    private final RoomService roomService;

    public ReservationService(ReservationRepository reservationRepository, HotelService hotelService, UserService userService, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.hotelService = hotelService;
        this.userService = userService;
        this.roomService = roomService;
    }

    public Reservation reserveHotel(ReserveDAO reserveDAO) {

        if(!this.isDurationValid(reserveDAO.reservationStartDate(), reserveDAO.reservationEndDate())) {
            throw new DurationException();
        }

        Hotel hotel = hotelService.getHotelById(reserveDAO.hotelId());
        Reservation reservation = new Reservation();
        reservation.setReservationStartDate(reserveDAO.reservationStartDate());
        reservation.setReservationEndDate(reserveDAO.reservationEndDate());
        User user = userService.getUserById(reserveDAO.userId());
        reservation.setUser(user);
        try {
            Room room =  roomService.getAvailableRoom();
            reservation.setRoom(room);
           return reservationRepository.save(reservation);
        } catch (Exception ex) {
            throw new ReservationException();
        }

    }

    public List<Reservation> getReservations() {
        return (List<Reservation>) this.reservationRepository.findAll();
    }

    public Reservation updateReservation(ReserveDAO reserveDAO) {
        if(!this.isDurationValid(reserveDAO.reservationStartDate(), reserveDAO.reservationEndDate())) {
            throw new DurationException();
        }
        User user = userService.getUserById(reserveDAO.userId());
        Optional<Reservation> reservationOptional  = reservationRepository.findById(user.getId());
        if(reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }
        Reservation reservation = reservationOptional.get();
        reservation.setReservationStartDate(reserveDAO.reservationStartDate());
        reservation.setReservationEndDate(reserveDAO.reservationEndDate());
        return reservationRepository.save(reservation);

    }

    public Reservation cancelReservation(ReserveDAO reserveDAO) {
        User user = userService.getUserById(reserveDAO.userId());
        Optional<Reservation> reservationOptional  = reservationRepository.findById(user.getId());
        if(reservationOptional.isEmpty()) {
            throw new NotFoundException();
        }

        reservationRepository.delete(reservationOptional.get());
        return reservationOptional.get();
    }

    private Boolean isDurationValid(Date startDate, Date endDate) {
        long dateBeforeInMs = startDate.getTime();
        long dateAfterInMs = endDate.getTime();

        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);

        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        if(daysDiff > 5) return false;
        return true;
    }

}
