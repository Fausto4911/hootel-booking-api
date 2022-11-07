package com.hotel.booking.bookingapi.dao.response;

import com.hotel.booking.bookingapi.entity.Reservation;

public record ReservationResponseDto(
        String hotel,
        String userName,
        String room
) {
    public static ReservationResponseDto assembleFromReservation(Reservation reservation) {
    return new ReservationResponseDto(
            reservation.getRoom().getHotel().getHotelName(),
            reservation.getUser().getUserName(),
            reservation.getRoom().getRoomName()
    );
    }
}



