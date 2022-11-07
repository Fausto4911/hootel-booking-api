package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.dao.ReserveDAO;
import com.hotel.booking.bookingapi.entity.Reservation;
import com.hotel.booking.bookingapi.entity.Room;
import com.hotel.booking.bookingapi.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    public final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getRooms(){
        return this.roomService.getRooms();
    }


}
