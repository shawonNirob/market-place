package com.shawon.marketplace.services;

import com.shawon.marketplace.entities.User;
import com.shawon.marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Comment out the PasswordEncoder dependency for testing
    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        // Temporarily skip encoding the password
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}