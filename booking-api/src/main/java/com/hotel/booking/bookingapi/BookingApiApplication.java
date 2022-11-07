package com.hotel.booking.bookingapi;

import com.hotel.booking.bookingapi.controller.UserController;
import com.hotel.booking.bookingapi.entity.Country;
import com.hotel.booking.bookingapi.entity.Hotel;
import com.hotel.booking.bookingapi.entity.Room;
import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.repository.CountryRepository;
import com.hotel.booking.bookingapi.repository.HotelRepository;
import com.hotel.booking.bookingapi.repository.RoomRepository;
import com.hotel.booking.bookingapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}


	@Bean
	public CommandLineRunner inintDatabase(UserRepository repository, CountryRepository countryRepository, HotelRepository hotelRepository, RoomRepository roomRepository) {
		return (args) -> {
			User user = new User();
			user.setUserName("Fausto Torres");
			User user2 = new User();
			user2.setUserName("Nahara Rosario");
			User user3 = new User();
			user3.setUserName("Gertrudis Diaz");

			repository.save(user);
			repository.save(user2);
			repository.save(user3);

			Country country = new Country();
			country.setCountryName("Dominican Republic");
			Country country2 = new Country();
			country2.setCountryName("Costa Rica");
			Country country3 = new Country();
			country3.setCountryName("United State");

			country = countryRepository.save(country);
			country2 = countryRepository.save(country2);
			country3 = countryRepository.save(country3);

			Hotel hotel = new Hotel();
			hotel.setHotelName("Bavaro Punta Cana");
			hotel = hotelRepository.save(hotel);
			hotel.setCountry(country);

			Set<Room> rooms = new HashSet<>();
			for(int i = 0; i < 20; i ++) {
				Room room = new Room();
				room.setAvailable(true);
				room.setHotel(hotel);
				room.setRoomName("000" + i);
				roomRepository.save(room);
				rooms.add(room);
			}
			hotel.setRooms(rooms);
			hotelRepository.save(hotel);

			Hotel hotel2 = new Hotel();
			hotel2.setHotelName("Hotel Luxury");
			hotel2 = hotelRepository.save(hotel2);
			hotel2.setCountry(country2);
			Set<Room> rooms2 = new HashSet<>();
			for(int i = 0; i < 20; i ++) {
				Room room = new Room();
				room.setAvailable(true);
				room.setHotel(hotel2);
				room.setRoomName("000" + i);
				roomRepository.save(room);
				rooms2.add(room);
			}
			hotel2.setRooms(rooms2);
			hotelRepository.save(hotel2);

			Hotel hotel3 = new Hotel();
			hotel3.setHotelName("Hotel Costa Rica");
			hotel3 = hotelRepository.save(hotel3);
			hotel3.setCountry(country2);
			Set<Room> rooms3 = new HashSet<>();
			for(int i = 0; i < 20; i ++) {
				Room room = new Room();
				room.setAvailable(true);
				room.setHotel(hotel3);
				room.setRoomName("000" + i);
				roomRepository.save(room);
				rooms3.add(room);
			}
			hotel3.setRooms(rooms3);
			hotelRepository.save(hotel3);

			Hotel hotel4 = new Hotel();
			hotel4.setHotelName("Hotel San Diego");
			hotel4 = hotelRepository.save(hotel4);
			hotel4.setCountry(country3);
			Set<Room> rooms4 = new HashSet<>();
			for(int i = 0; i < 20; i ++) {
				Room room = new Room();
				room.setAvailable(true);
				room.setHotel(hotel4);
				room.setRoomName("000" + i);
				roomRepository.save(room);
				rooms4.add(room);
			}
			hotel4.setRooms(rooms4);
			hotelRepository.save(hotel4);

			Hotel hotel5 = new Hotel();
			hotel5.setHotelName("Hotel Costa Dorada");
			hotel5 = hotelRepository.save(hotel5);
			hotel5.setCountry(country3);
			Set<Room> rooms5 = new HashSet<>();
			for(int i = 0; i < 20; i ++) {
				Room room = new Room();
				room.setAvailable(true);
				room.setHotel(hotel5);
				room.setRoomName("000" + i);
				roomRepository.save(room);
				rooms5.add(room);
			}
			hotel5.setRooms(rooms5);
			hotelRepository.save(hotel5);


		};
	}

}
