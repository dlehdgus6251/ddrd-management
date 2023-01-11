package com.ddrd.management.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CommonController {
    @GetMapping("/main")
    public String home(){

        
        System.out.println("main");
                
        return "main";
    }
}
