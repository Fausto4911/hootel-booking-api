package com.hotel.booking.bookingapi.dao.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


public record ReserveDAO(
        Long userId,
        @JsonFormat(pattern="yyyy-MM-dd")
        Date reservationStartDate,

        @JsonFormat(pattern="yyyy-MM-dd")
        Date reservationEndDate,
        Long hotelId
        )
{

}
