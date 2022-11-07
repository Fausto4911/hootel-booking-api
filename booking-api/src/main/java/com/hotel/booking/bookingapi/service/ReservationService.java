package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation reserveHotel() {

         return new Reservation();
    }

}
