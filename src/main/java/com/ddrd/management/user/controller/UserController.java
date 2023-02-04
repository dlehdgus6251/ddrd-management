package com.ddrd.management.user.controller;

import com.ddrd.management.common.domain.LoginResponse;
import com.ddrd.management.common.service.LoginService;
import com.ddrd.management.user.domain.UserDto;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final LoginService loginService;
    @GetMapping("/users")
    public void getUsers(){

    }
    @GetMapping("/users/new")
    public String getUsersNew(){
        return "signUp";
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<LoginResponse> getUser(@PathVariable("userId") String userId) throws Exception {

        return new ResponseEntity<>( loginService.getuserEntity(userId), HttpStatus.OK);
    }

    @PostMapping("/user")
    @ResponseBody
    public UserDto insertUser(@RequestBody UserDto userDto){
        return userDto;
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable("id") long id) {

    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") long id) {

    }
}
