package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.repository.UserRepository;
import com.hotel.booking.bookingapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public final UserService userRepository;

    public UserController(UserService userService) {
        this.userRepository = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) this.userRepository.getUsers();
    }
}
