package com.ddrd.management.gather.controller;

import com.ddrd.management.gather.domain.GatherDto;
import com.ddrd.management.gather.service.GatherService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/gather")
public class GatherController {

    private final GatherService gatherService;
    @GetMapping(value = "/main")
    public String getGather(){
        return "/gather/main";
    }

    @GetMapping(value = "/gathers")
    @ResponseBody
    public List<GatherDto> getGathers(){
        List<GatherDto> resultList = new ArrayList<GatherDto>();
        resultList = gatherService.getGathers();
        return resultList;
    }

    @GetMapping(value = "/gather/{id}")
    @ResponseBody
    public GatherDto getGather(@PathVariable(value = "id") long gatherNo){
        GatherDto result = new GatherDto();
        result = gatherService.getGather(gatherNo);
        return result;
    }

    @PostMapping(value = "/gather")
    @ResponseBody
    public void insertGather(@RequestBody GatherDto dto){
        gatherService.insertGather(dto);
    }

    @PutMapping(value = "/gather")
    @ResponseBody
    public void updateGather(@RequestBody GatherDto dto){
        gatherService.updateGather(dto);
    }

    @DeleteMapping(value = "/gather/{id}")
    public void deleteGather(@PathVariable(value = "id") long gatherNo){
        gatherService.deleteGather(gatherNo);
    }

}
