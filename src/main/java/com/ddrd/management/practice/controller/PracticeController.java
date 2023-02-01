package com.ddrd.management.practice.controller;

import com.ddrd.management.practice.domain.PracticeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class PracticeController {
@GetMapping(value = "/practice")
    public String practice(){
        return "";
    }
    @GetMapping(value = "/practices")
    public String practices(Model model){
        List<PracticeDto> practiceDtoList = new ArrayList<>();
        model.addAttribute("practiceList", practiceDtoList);
        return "practice/main";
    }
}
