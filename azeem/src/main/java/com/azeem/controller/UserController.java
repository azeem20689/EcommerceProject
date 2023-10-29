package com.azeem.controller;

import com.azeem.dto.UserDto;
import com.azeem.entities.User;
import com.azeem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/createUser")
    public ResponseEntity<User> registerUser(@RequestBody UserDto user){
        System.out.println("USER RECEIVED"+user);
        return userService.saveUser(user);
    }
}
