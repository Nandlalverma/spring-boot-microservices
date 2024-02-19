package com.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.userService.entity.User;
import com.userService.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
    private  UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userSave = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userSave);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User userById = userService.getUserById(userId);
        return ResponseEntity.ok(userById);
    }

}
