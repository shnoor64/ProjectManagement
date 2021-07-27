package com.simbirsoft.belousov.mappers.impl;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.mappers.ReleaseMapper;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;

public class ReleaseMapperImpl implements ReleaseMapper {

    @Override
    public ReleaseEntity ReleaseRequestDtoToEntity(ReleaseRequestDto releaseRequestDto) {
        if (releaseRequestDto == null) {
            return null;
        }
        return null;
    }

    @Override
    public ReleaseResponseDto ReleaseEntityToResponseDto(ReleaseEntity releaseEntity) {
        if (releaseEntity == null) {
            return null;
        }
        return null;
    }
}
