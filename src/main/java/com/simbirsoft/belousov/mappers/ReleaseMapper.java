package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ReleaseMapper {

    ReleaseEntity ReleaseRequestDtoToEntity(ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto ReleaseEntityToResponseDto(ReleaseEntity releaseEntity);

}
