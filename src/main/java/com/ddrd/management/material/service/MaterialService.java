package com.ddrd.management.material.service;

import com.ddrd.management.material.domain.MaterialDto;
import com.ddrd.management.material.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;
//    public List<MaterialDto> getMaterials(){
//        return materialRepository.getMaterials();
//    }
//
//    public MaterialDto getMaterial(long materialNo) { return materialRepository.getMaterial(materialNo); }
//
//    public void insertMaterial(MaterialDto materialDto) {
//        materialRepository.insertMaterial(materialDto);
//    }
//
//    public void updateMaterial(MaterialDto materialDto) {
//        materialRepository.updateMaterial(materialDto);
//    }
//
//    public void deleteMaterial(long materialNo) {
//        materialRepository.deleteMaterial(materialNo);
//    }
}
