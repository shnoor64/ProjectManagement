package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper {

    ProjectEntity projectRequestDtoToEntity(ProjectRequestDto projectRequestDto);

    ProjectResponseDto projectEntityToResponseDto(ProjectEntity projectEntity);

}
