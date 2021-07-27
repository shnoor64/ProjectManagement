package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.dto.ReleaseRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    ProjectEntity ProjectRequestDtoToEntity(ProjectRequestDto projectRequestDto);

    ProjectResponseDto ProjectEntityToResponseDto(ProjectEntity projectEntity);

}
