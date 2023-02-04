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
    public List<MaterialDto> getMaterials(){
        return materialRepository.getMaterials();
    }

    public MaterialDto getMaterial() {
        return materialRepository.getMaterial();
    }
}
