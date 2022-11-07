package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.dao.request.ReserveDAO;
import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.entity.Room;
import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
            return null;
        }

    }

    public List<Reservation> getReservations() {
        return (List<Reservation>) this.reservationRepository.findAll();
    }

}
