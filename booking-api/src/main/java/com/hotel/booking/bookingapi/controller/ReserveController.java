package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.dao.ReserveDAO;
import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserve")
public class ReserveController {

    public final ReservationService reservationService;

    public ReserveController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return this.reservationService.getReservations();
    }

    @PostMapping
    public Reservation Reserve(@RequestBody ReserveDAO reserveDAO) {
        return this.reservationService.reserveHotel(reserveDAO);
    }
}