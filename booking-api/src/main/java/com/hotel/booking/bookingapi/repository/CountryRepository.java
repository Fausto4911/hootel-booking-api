package com.hotel.booking.bookingapi.repository;

import com.hotel.booking.bookingapi.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
