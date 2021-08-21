package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProjectMapperTest {

    @Test
    void ProjectRequestDtoMappingEntity() {
        ProjectMapper projectMapper = new ProjectMapperImpl();
        ProjectRequestDto projectRequestDto = new ProjectRequestDto(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);

        ProjectEntity projectEntity = projectMapper.projectRequestDtoToEntity(projectRequestDto);

        Assertions.assertEquals(projectRequestDto.getProjectId(), projectEntity.getProjectId());
        Assertions.assertEquals(projectRequestDto.getName(), projectEntity.getName());
        Assertions.assertEquals(projectRequestDto.getDescriptionProject(), projectEntity.getDescriptionProject());
        Assertions.assertEquals(projectRequestDto.getStatusProject(), projectEntity.getStatusProject());
        Assertions.assertEquals(projectRequestDto.getCustomer(), projectEntity.getCustomer());
        Assertions.assertEquals(projectRequestDto.getPaymentStatus(), projectEntity.getPaymentStatus());

    }
}
