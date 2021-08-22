package com.simbirsoft.belousov.servuce;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.mappers.ProjectMapper;
import com.simbirsoft.belousov.mappers.ProjectMapperImpl;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.servise.ProjectService;
import com.simbirsoft.belousov.servise.impl.ProjectServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {
    private ProjectEntity projectEntity;
    private ProjectService projectService;

    @Mock
    ProjectRepository projectRepository;
    @Mock
    TaskRepository taskRepository;

    @BeforeEach
    void prepare() {
        projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);
        ProjectMapper projectMapper = new ProjectMapperImpl();
        projectService = new ProjectServiceImpl(projectRepository, taskRepository, projectMapper);
    }

    @Test
    void InProgressStatusOfThePaidProject() {
        Mockito.when(projectRepository.findById(1)).thenReturn(Optional.of(projectEntity));

        ProjectResponseDto projectResponseDto = projectService.updateStatusProject(projectEntity.getProjectId(), "IN_PROGRESS");

        Assertions.assertEquals(projectEntity.getStatusProject(), projectResponseDto.getStatusProject());
    }

    @Test
    void ClosedStatusOfTheAllTaskCompleted() {
        Mockito.when(projectRepository.findById(1)).thenReturn(Optional.of(projectEntity));
        Mockito.when(taskRepository.countAllNotDoneTasksByProject(projectEntity.getProjectId())).thenReturn(0);

        ProjectResponseDto projectResponseDto = projectService.updateStatusProject(projectEntity.getProjectId(), "CLOSED");

        Assertions.assertEquals(projectEntity.getStatusProject(), projectResponseDto.getStatusProject());

    }
}