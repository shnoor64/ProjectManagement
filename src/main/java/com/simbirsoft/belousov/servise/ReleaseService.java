package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;

import java.util.List;

public interface ReleaseService {
    List<ReleaseResponseDto> getAllReleases();

    ReleaseResponseDto getReleaseById(int id);

    ReleaseResponseDto addRelease(ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto, int id);

    void deleteRelease(int id);
}
