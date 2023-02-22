package com.ddrd.management.material.repository;

import com.ddrd.management.material.domain.MaterialDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MaterialRepository {
    List<MaterialDto> getMaterials();
    MaterialDto getMaterial(long materialNo);

    void insertMaterial(MaterialDto materialDto);

    void updateMaterial(MaterialDto materialDto);

    void deleteMaterial(long materialNo);
}
