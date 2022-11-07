package com.hotel.booking.bookingapi.repository;

import com.hotel.booking.bookingapi.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {


}
