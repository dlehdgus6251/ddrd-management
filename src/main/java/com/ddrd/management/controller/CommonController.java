package com.ddrd.management.controller;


import com.ddrd.management.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommonController {

    @GetMapping("/api/v1/health")
    @ResponseStatus(HttpStatus.OK)
    public String healthCheck() {
        return "ok3";
    }

    @GetMapping("/main")
    public String home(){
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login2";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        System.out.println("login user :: {}"+ userDto.toString());
        return "aa";
    }

}
