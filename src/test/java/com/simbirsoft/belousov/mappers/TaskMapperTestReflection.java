package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.*;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TaskMapperTestReflection {
    private TaskMapper taskMapper;
    private ReleaseEntity releaseEntity;
    private UserEntity userEntity;
    private ProjectEntity projectEntity;

    @BeforeEach
    void prepare() {
        taskMapper = new TaskMapperImpl();
        releaseEntity = new ReleaseEntity(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));
        userEntity = new UserEntity(1, "Oleg", "Olegov", "password", new RoleEntity(1, "admin"));
        projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);
    }

    @Mock
    ProjectRepository projectRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    ReleaseRepository releaseRepository;

    @Test
    void TaskRequestDtoMappingEntity() {
//        TaskMapper taskMapper = new TaskMapperImpl();
//        RoleEntity roleEntity = new RoleEntity(1, "admin");
//        UserEntity userEntity = new UserEntity(1, "Oleg", "Olegov", "password", roleEntity);
//        ProjectEntity projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);
//        ReleaseEntity releaseEntity = new ReleaseEntity(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
//                LocalDateTime.of(2022, 8, 8, 14, 0));
        TaskRequestDto taskRequestDto = new TaskRequestDto(1, "velo", "add velo", 1, StatusTask.DONE, 1, 1, 1, 2,
                LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2021, 8, 8, 14, 0));
        Mockito.when(projectRepository.findById(1)).thenReturn(Optional.of(projectEntity));
        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userEntity));
        Mockito.when(releaseRepository.findById(1)).thenReturn(Optional.of(releaseEntity));
        ReflectionTestUtils.setField(taskMapper, "projectRepository", projectRepository);
        ReflectionTestUtils.setField(taskMapper, "userRepository", userRepository);
        ReflectionTestUtils.setField(taskMapper, "releaseRepository", releaseRepository);

        TaskEntity taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);

        Mockito.verify(projectRepository, Mockito.times(1)).findById(1);
        Mockito.verify(userRepository, Mockito.times(2)).findById(1);
        Mockito.verify(releaseRepository, Mockito.times(1)).findById(1);
        Assertions.assertEquals(taskRequestDto.getTaskId(), taskEntity.getTaskId());
        Assertions.assertEquals(taskRequestDto.getName(), taskEntity.getName());
        Assertions.assertEquals(taskRequestDto.getDescriptionTask(), taskEntity.getDescriptionTask());
        Assertions.assertEquals(taskRequestDto.getProjectId(), taskEntity.getProjectId().getProjectId());
        Assertions.assertEquals(taskRequestDto.getStatusTask(), taskEntity.getStatusTask());
        Assertions.assertEquals(taskRequestDto.getAuthorId(), taskEntity.getAuthorId().getUserId());
        Assertions.assertEquals(taskRequestDto.getPerformerId(), taskEntity.getPerformerId().getUserId());
        Assertions.assertEquals(taskRequestDto.getReleaseId(), taskEntity.getReleaseId().getReleaseId());
        Assertions.assertEquals(taskRequestDto.getTimeToComplete(), taskEntity.getTimeToComplete());
        Assertions.assertEquals(taskRequestDto.getStartTimeTask(), taskEntity.getStartTimeTask());
        Assertions.assertEquals(taskRequestDto.getEndTimeTask(), taskEntity.getEndTimeTask());
    }

    @Test
    void TaskEntityMappingResponseDto() {
        TaskEntity taskEntity = new TaskEntity(1, "velo", "add velo", projectEntity, StatusTask.DONE, userEntity, userEntity, releaseEntity, 2,
                LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2021, 8, 8, 14, 0));

        TaskResponseDto taskResponseDto = taskMapper.taskEntityToResponseDto(taskEntity);

        Assertions.assertEquals(taskEntity.getTaskId(), taskResponseDto.getTaskId());
        Assertions.assertEquals(taskEntity.getName(), taskResponseDto.getName());
        Assertions.assertEquals(taskEntity.getDescriptionTask(), taskResponseDto.getDescriptionTask());
        Assertions.assertEquals(taskEntity.getProjectId().getProjectId(), taskResponseDto.getProjectId());
        Assertions.assertEquals(taskEntity.getStatusTask(), taskResponseDto.getStatusTask());
        Assertions.assertEquals(taskEntity.getAuthorId().getUserId(), taskResponseDto.getAuthorId());
        Assertions.assertEquals(taskEntity.getPerformerId().getUserId(), taskResponseDto.getPerformerId());
        Assertions.assertEquals(taskEntity.getReleaseId().getReleaseId(), taskResponseDto.getReleaseId());
        Assertions.assertEquals(taskEntity.getTimeToComplete(), taskResponseDto.getTimeToComplete());
        Assertions.assertEquals(taskEntity.getStartTimeTask(), taskResponseDto.getStartTimeTask());
        Assertions.assertEquals(taskEntity.getEndTimeTask(), taskResponseDto.getEndTimeTask());

    }
}
