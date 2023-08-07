package com.ddrd.management.gather.controller;

import com.ddrd.management.gather.domain.GatherDto;
import com.ddrd.management.gather.domain.GatherEntity;
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

    /**
     * 정기 모임 조회
     * @return list
     */
    @GetMapping(value = "/gathers")
    @ResponseBody
    public List<GatherEntity> getGathers(){ return gatherService.getGathers(); }
//
//    /**
//     * 정기 모임 상세 조회
//     * @param gatherNo
//     * @return Object
//     */
//    @GetMapping(value = "/gather/{id}")
//    @ResponseBody
//    public GatherDto getGather(@PathVariable(value = "id") long gatherNo){ return gatherService.getGather(gatherNo); }
//
//    /**
//     *
//     * @param dto
//     */
//    @PostMapping(value = "/gather")
//    @ResponseBody
//    public void insertGather(@RequestBody GatherDto dto){ gatherService.insertGather(dto); }
//
//    @PutMapping(value = "/gather")
//    @ResponseBody
//    public void updateGather(@RequestBody GatherDto dto){
//        gatherService.updateGather(dto);
//    }
//
//    @DeleteMapping(value = "/gather/{id}")
//    public void deleteGather(@PathVariable(value = "id") long gatherNo){
//        gatherService.deleteGather(gatherNo);
//    }

}
