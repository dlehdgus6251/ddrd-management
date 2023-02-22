package com.ddrd.management.material.controller;

import com.ddrd.management.material.domain.MaterialDto;
import com.ddrd.management.material.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/material")
public class MaterialController {
    private final MaterialService materialService;
    @GetMapping(value = "/material")
    public String view(){
        return "material/main";
    }
//
//    /**
//     * 소재 전체 조회(thymeleaf 용)
//     * @param model
//     * @return String
//     */
//    @GetMapping(value = "/materials")
//    public String materials(Model model){
//        List<MaterialDto> materialDtoList = new ArrayList<>();
//        materialDtoList = materialService.getMaterials();
//        model.addAttribute("materialList", materialDtoList);
//        return "material/main";
//    }

    /**
     * 소재 전체 조회(api 용)
     * @return materialDtoList
     */
    @GetMapping("/materials")
    public ResponseEntity<List<MaterialDto>> getMaterials(){
        return new ResponseEntity<>(materialService.getMaterials(), HttpStatus.OK);
    }

    /**
     * 소재 상세 조회
     * @param materialNo
     * @return
     */
    @GetMapping("/material/{id}")
    public ResponseEntity<MaterialDto> getMaterial(@PathVariable("id") long materialNo) {
        return new ResponseEntity<>( materialService.getMaterial(materialNo), HttpStatus.OK);
    }

    /**
     * 소재 등록
     * @param materialDto
     * @return
     */
    @PostMapping("/material")
    public ResponseEntity<HttpStatus> insertMaterial(@RequestBody MaterialDto materialDto) {
        materialService.insertMaterial(materialDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 소재 수정
     * @param materialDto
     * @param
     * @return
     */
    @PutMapping("/material")
    public ResponseEntity<HttpStatus> updateMaterial (@RequestBody MaterialDto materialDto){
        materialService.updateMaterial(materialDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/material/{id}")
    public ResponseEntity<HttpStatus> deleteMaterial(@PathVariable("id") long materialno){
        materialService.deleteMaterial(materialno);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
