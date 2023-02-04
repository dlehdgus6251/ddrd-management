package com.ddrd.management.material.controller;

import com.ddrd.management.material.domain.MaterialDto;
import com.ddrd.management.material.service.MaterialService;
import com.ddrd.management.user.UserRoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/material")
public class MaterialController {
    private final MaterialService materialService;
    @GetMapping(value = "/material")
    public String view(){
        return "material/main";
    }

    /**
     * 소재 전체 조회(thymeleaf 용)
     * @param model
     * @return String
     */
    @GetMapping(value = "/materials")
    public String materials(Model model){
        List<MaterialDto> materialDtoList = new ArrayList<>();
        materialDtoList = materialService.getMaterials();
        log.info("## 소재 전체 조회 :: {}", materialDtoList.toString());
        model.addAttribute("materialList", materialDtoList);
        return "material/main";
    }

    /**
     * 소재 전체 조회(api 용)
     * @return materialDtoList
     */
    @GetMapping("/materialsaa")
    @ResponseBody
    public List<MaterialDto> materials(){
        return materialService.getMaterials();
    }

    @GetMapping("/materialaa")
    public MaterialDto material() {
        return materialService.getMaterial();
    }
}
