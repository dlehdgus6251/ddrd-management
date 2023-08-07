package com.ddrd.management.gather.service;

import com.ddrd.management.gather.domain.GatherDto;
import com.ddrd.management.gather.domain.GatherEntity;
import com.ddrd.management.gather.repository.GatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GatherService {

    final GatherRepository gatherRepository;

    public List<GatherEntity> getGathers() {
        return gatherRepository.findAll();
    }

//    public GatherDto getGather(long gatherNo) {
//        return gatherRepository.getGather();
//    }
//
//    public void insertGather(GatherDto dto) {
//        gatherRepository.insertGather(dto);
//    }
//
//    public void updateGather(GatherDto dto) {
//        gatherRepository.updateGather(dto);
//    }
//
//    public void deleteGather(long gatherNo) {
//        gatherRepository.deleteGather(gatherNo);
//    }
}
