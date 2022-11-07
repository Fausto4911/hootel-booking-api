package com.hotel.booking.bookingapi.service;

import com.hotel.booking.bookingapi.entity.User;
import com.hotel.booking.bookingapi.exception.NotFoundException;
import com.hotel.booking.bookingapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserById(Long userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new NotFoundException();
        }
        return userOptional.get();
    }

}
