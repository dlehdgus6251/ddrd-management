package com.ddrd.management.gather.service;

import com.ddrd.management.gather.domain.GatherDto;
import com.ddrd.management.gather.repository.GatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GatherService {

    private final GatherRepository gatherRepository;

    public List<GatherDto> getGathers() {
        return gatherRepository.getGathers();
    }

    public GatherDto getGather(long gatherNo) {
        return gatherRepository.getGather();
    }

    public void insertGather(GatherDto dto) {
        gatherRepository.insertGather();
    }

    public void updateGather(GatherDto dto) {
        gatherRepository.updateGather();
    }

    public void deleteGather(long gatherNo) {
        gatherRepository.deleteGather();
    }
}
