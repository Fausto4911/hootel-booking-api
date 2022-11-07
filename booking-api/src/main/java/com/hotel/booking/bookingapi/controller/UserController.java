package com.hotel.booking.bookingapi.controller;

import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    public final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers() {
        return (List<User>) this.userRepository.findAll();
    }
}
