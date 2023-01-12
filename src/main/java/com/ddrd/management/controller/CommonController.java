package com.ddrd.management.controller;


import com.ddrd.management.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CommonController {
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
