package com.hotel.booking.bookingapi.dao;

import java.util.Date;


public record ReserveDAO(
        Long userId,
        Date reservationStartDate,
        Date reservationEndDate,
        Long hotelId
        )
{

}
