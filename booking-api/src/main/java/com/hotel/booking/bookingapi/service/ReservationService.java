package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.dao.ReserveDAO;
import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final HotelService hotelService;

    public ReservationService(ReservationRepository reservationRepository, HotelService hotelService) {
        this.reservationRepository = reservationRepository;
        this.hotelService = hotelService;
    }

    public Reservation reserveHotel(ReserveDAO reserveDAO) {
        Hotel hotel = hotelService.getHotelById(reserveDAO.hotelId());
        return new Reservation();
    }

    public List<Reservation> getReservations() {
        return (List<Reservation>) this.reservationRepository.findAll();
    }

}
