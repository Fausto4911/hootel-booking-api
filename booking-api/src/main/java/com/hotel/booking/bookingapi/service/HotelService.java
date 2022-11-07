package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.exception.NotFoundException;
import com.hotel.booking.bookingapi.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {


    public final HotelRepository hotelRepository;


    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getHotels() {
        return (List<Hotel>)this.hotelRepository.findAll();
    }

    public Hotel getHotelById(Long hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        if(hotelOptional.isEmpty()) {
            throw new NotFoundException();
        }
        return hotelOptional.get();

    }
}
