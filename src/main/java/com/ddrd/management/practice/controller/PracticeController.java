package com.ddrd.management.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {
@GetMapping(value = "/practice")
    public String practice(){
        return "";
    }
}
