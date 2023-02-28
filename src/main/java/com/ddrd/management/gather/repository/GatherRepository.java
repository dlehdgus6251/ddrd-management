package com.ddrd.management.gather.repository;

import com.ddrd.management.gather.domain.GatherDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface GatherRepository {
    List<GatherDto> getGathers();

    GatherDto getGather();

    void insertGather();

    void updateGather();

    void deleteGather();
}
