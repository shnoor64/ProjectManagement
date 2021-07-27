package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ProjectEntity;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface ReleaseMapper {

    ReleaseEntity ReleaseRequestDtoToEntity(ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto ReleaseEntityToResponseDto(ReleaseEntity releaseEntity);

}
