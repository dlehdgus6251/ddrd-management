package com.ddrd.management.controller;

import com.ddrd.management.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @GetMapping("/users")
    public void getUsers(){

    }

    @GetMapping("/user/{id}")
    public void getUser(@PathVariable("id") long id){

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
