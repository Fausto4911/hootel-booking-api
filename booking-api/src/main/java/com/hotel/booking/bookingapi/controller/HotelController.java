package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {


    public final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> getHotels() {
    return this.hotelService.getHotels();
    }
}
