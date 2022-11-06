package com.hotel.booking.bookingapi.repository;

import com.hotel.booking.bookingapi.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
