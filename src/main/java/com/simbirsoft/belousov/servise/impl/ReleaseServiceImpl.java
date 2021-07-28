package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.servise.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public List<ReleaseResponseDto> getAllReleases() {
        return null;
    }

    @Override
    public ReleaseResponseDto getReleaseById(int id) {
        return null;
    }

    @Override
    public ReleaseResponseDto addRelease(ReleaseRequestDto releaseRequestDto) {
        return null;
    }

    @Override
    public ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto) {
        return null;
    }

    @Override
    public void deleteRelease(int id) {

    }
}
