package com.nexo.springfeatures.controller;

import com.nexo.springfeatures.dto.UserData;
import com.nexo.springfeatures.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/booking/1.0.0/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserData> getResponse(@PathVariable("userId") Long userId){
        UserData userData = userService.getUserById(userId);
        return new ResponseEntity<UserData>(userData, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<UserData> createUser(@RequestBody UserData userData) {
        UserData createdUserData = userService.saveUser(userData);
        return new ResponseEntity<>(createdUserData, HttpStatus.CREATED);
    }
}
