package com.simbirsoft.belousov.mappers.impl;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.mappers.ProjectMapper;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;

public class ProjectMapperImpl implements ProjectMapper {
    @Override
    public ProjectEntity ProjectRequestDtoToEntity(ProjectRequestDto projectRequestDto) {
        if (projectRequestDto == null) {
            return null;
        }
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectId(projectRequestDto.getProjectId());
        projectEntity.setName(projectRequestDto.getName());
        projectEntity.setDescriptionProject(projectRequestDto.getDescriptionProject());
        projectEntity.setCustomer(projectRequestDto.getCustomer());
        projectEntity.setStatusProject(projectRequestDto.getStatusProject());
        return projectEntity;
    }

    @Override
    public ProjectResponseDto ProjectEntityToResponseDto(ProjectEntity projectEntity) {
        if (projectEntity == null) {
            return null;
        }
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setProjectId(projectEntity.getProjectId());
        projectResponseDto.setName(projectEntity.getName());
        projectResponseDto.setDescriptionProject(projectEntity.getDescriptionProject());
        projectResponseDto.setCustomer(projectEntity.getCustomer());
        projectResponseDto.setStatusProject(projectEntity.getStatusProject());
        return projectResponseDto;
    }
}
