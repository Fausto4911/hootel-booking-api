package com.hotel.booking.bookingapi.repository;


import com.hotel.booking.bookingapi.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
