package com.hotel.booking.bookingapi.repository;

import com.hotel.booking.bookingapi.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
