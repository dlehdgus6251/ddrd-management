package com.ddrd.management.material.repository;

import com.ddrd.management.material.domain.MaterialDto;
import com.ddrd.management.material.domain.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    List<MaterialEntity> findAll();
//    List<MaterialDto> getMaterials();
//    MaterialDto getMaterial(long materialNo);
//
//    void insertMaterial(MaterialDto materialDto);
//
//    void updateMaterial(MaterialDto materialDto);
//
//    void deleteMaterial(long materialNo);
}
