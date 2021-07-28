package com.thkoeln.hct.backend.application.controller;

import com.thkoeln.hct.backend.application.service.UserService;
import com.thkoeln.hct.backend.domain.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser() {
        logger.debug("GET: getAlluser");
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        logger.debug("GET: getuserById");
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.debug("POST: createUser");
        return new ResponseEntity(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        logger.debug("PUT: updateUser");
        return new ResponseEntity(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping  ("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        logger.debug("DELETE: deleteUser");
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
