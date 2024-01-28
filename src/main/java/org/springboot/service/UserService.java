package org.springboot.service;

import org.springboot.model.User;
import org.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByCity(String city) {
        return userRepository.findAllByAddressCity(city);
    }

    public User getUserByUserId(int userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public String saveNewUser(User user) {
        User savedUser = userRepository.save(user);
        String msgOnSave = "User with username %s and email %s has been saved";
        return String.format(msgOnSave, savedUser.getUsername(), savedUser.getEmail());
    }

    public String deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            String msgOnSave = "User with userId %s has been deleted";
            return String.format(msgOnSave, userId);
        } else {
            return "No such user found";
        }
    }

    public String updateUser(int userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User savedUser = userRepository.save(updatedUser);
            String msgOnSave = "User with username %s and email %s has been saved";
            return String.format(msgOnSave, savedUser.getUsername(), savedUser.getEmail());
        } else {
            return "No such user found";
        }
    }

    public String updateEmailByUsername(String username, String updatedEmail) {
        User updatedUser = userRepository.updateEmailByUsername(username, updatedEmail);
        if (updatedUser != null) {
            String msgOnEmailUpdate = "User with username %s has updated their email to %s";
            return String.format(msgOnEmailUpdate, updatedUser.getUsername(), updatedUser.getEmail());
        }
        else {
            return "No such user found";
        }
    }

}
