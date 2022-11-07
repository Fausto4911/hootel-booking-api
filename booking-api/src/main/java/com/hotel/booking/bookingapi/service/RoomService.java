package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.entity.Room;
import com.hotel.booking.bookingapi.exception.NotFoundException;
import com.hotel.booking.bookingapi.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    public final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return (List<Room>) this.roomRepository.findAll();
    }

    public Room getAvailableRoom() throws Exception {
        Room available = null;
        this.roomRepository.findAll().forEach(room -> {
            if (room.getAvailable()) {
                room = available;
            }
        });
        if(available == null) {
            throw new NotFoundException();
        }

        return available;
    }
}
