package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.dao.request.ReserveDAO;
import com.hotel.booking.bookingapi.dao.response.ReservationResponseDto;
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
    public ReservationResponseDto reserve(@RequestBody ReserveDAO reserveDAO) {
        return ReservationResponseDto.assembleFromReservation(this.reservationService.reserveHotel(reserveDAO));
    }

    @PutMapping
    public ReservationResponseDto updateReservation(@RequestBody ReserveDAO reserveDAO) {
        return ReservationResponseDto.assembleFromReservation(this.reservationService.updateReservation(reserveDAO));
    }

    @DeleteMapping
    public ReservationResponseDto cancelReservation(@RequestBody ReserveDAO reserveDAO) {
        return ReservationResponseDto.assembleFromReservation(this.reservationService.cancelReservation(reserveDAO));

    }
}
