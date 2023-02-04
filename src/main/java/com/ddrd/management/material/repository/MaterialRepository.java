package com.ddrd.management.material.repository;

import com.ddrd.management.material.domain.MaterialDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface MaterialRepository {
    List<MaterialDto> getMaterials();

    MaterialDto getMaterial();
}
