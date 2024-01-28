package org.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.model.User;
import org.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public List<User> getUsers() {
        logger.info("Getting all the users from User database");
        return userService.getAllUsers();
    }

    @GetMapping("get-by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get-by-city")
    public ResponseEntity<List<User>> getUsersByCity(@RequestParam String city) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByCity(city));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserByUsername(@PathVariable int userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveNewUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        String response = userService.deleteUser(userId);
        if (response.equals("No such user found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        String response = userService.updateUser(userId, updatedUser);
        if (response.equals("No such user found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-email")
    public ResponseEntity<String> updateEmailByUsername(@RequestParam String username, @RequestParam String updatedEmail) {
        String response = userService.updateEmailByUsername(username, updatedEmail);
        if (response.equals("No such user found")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


}
