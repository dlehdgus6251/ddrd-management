package com.ddrd.management.gather.repository;

import com.ddrd.management.gather.domain.GatherDto;
import com.ddrd.management.gather.domain.GatherEntity;
import com.ddrd.management.material.domain.MaterialEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface GatherRepository extends JpaRepository<GatherEntity, Long> {
    List<GatherEntity> findAll();
//    List<GatherDto> getGathers();
//
//    /**
//     * 정기 모임 상세
//     * @return
//     */
//    GatherDto getGather();
//
//    void insertGather(GatherDto dto);
//
//    void updateGather(GatherDto dto);
//
//    void deleteGather(long gatherNo);
}
