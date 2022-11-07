package com.hotel.booking.bookingapi;

import com.hotel.booking.bookingapi.controller.UserController;
import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(UserRepository repository, UserController userController) {
		return (args) -> {
			// save a few customers
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>> demo inserting users ");
			User user = new User();
			user.setUserName("Fausto Torres");

			User user2 = new User();
			user2.setUserName("Nahara Rosario");

			User user3 = new User();
			user3.setUserName("Gertrudis Diaz");

			repository.save(user);
			repository.save(user2);
			repository.save(user3);
			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>> demo inserting users");
//			System.out.println(" >>>>>>>>>>>>>>>>>>>>>>> demo insert ");
//			System.out.println(userController.getUsers());
		};
	}

}
