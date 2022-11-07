package com.hotel.booking.bookingapi;

import com.hotel.booking.bookingapi.controller.ReserveController;
import com.hotel.booking.bookingapi.dao.request.ReserveDAO;
import com.hotel.booking.bookingapi.dao.response.ReservationResponseDto;
import com.hotel.booking.bookingapi.entity.*;
import com.hotel.booking.bookingapi.exception.DurationException;
import com.hotel.booking.bookingapi.repository.*;
import com.hotel.booking.bookingapi.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReservationControllerTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void contextLoads() throws Exception {
        assertThat(reservationRepository).isNotNull();
    }

    @Test
    public void createReservationDurationExceptionTest() {
        User user = new User();
        user.setUserName("Fausto Torres");
        user = userRepository.save(user);
        assertThat(user).isNotNull();
        assertThat(user).hasFieldOrPropertyWithValue("userName", "Fausto Torres");

        Country country = new Country();
        country.setCountryName("Dominican Republic");
        country = countryRepository.save(country);
        assertThat(country).isNotNull();
        assertThat(country).hasFieldOrPropertyWithValue("countryName", "Dominican Republic");

        Hotel hotel = new Hotel();
        hotel.setHotelName("Bavaro Punta Cana");

        hotel = hotelRepository.save(hotel);
        hotel.setCountry(country);
        assertThat(hotel).isNotNull();
        assertThat(hotel).hasFieldOrPropertyWithValue("hotelName", "Bavaro Punta Cana");

        hotel = hotelRepository.save(hotel);


        Room room = new Room();
        room.setAvailable(true);
        room.setHotel(hotel);
        room.setRoomName("1001");
        room = roomRepository.save(room);
        assertThat(room).isNotNull();
        assertThat(room).hasFieldOrPropertyWithValue("roomName", "1001");

        Date reservationStartDate = new Date(2022,1,5 ); //@JsonFormat(pattern="yyyy-MM-dd")
        Date reservationEndDate = new Date(2022,1,11);
        ReserveDAO reservation = new ReserveDAO(user.getId(), reservationStartDate, reservationEndDate,hotel.getId());


        Exception exception = assertThrows(DurationException.class, () -> {
            reservationService.reserveHotel(reservation);
        });


    }

}

