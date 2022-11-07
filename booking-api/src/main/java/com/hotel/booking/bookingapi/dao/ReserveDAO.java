package com.hotel.booking.bookingapi.dao;

import java.util.Date;


public record ReserveDAO(
        String userName,
        Date reservationStartDate,
        Date reservationEndDate,
        Long hotelId
        )
{

}
