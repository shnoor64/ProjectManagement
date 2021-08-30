package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.ProjectManagerApplication;
import com.simbirsoft.belousov.entity.*;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest(
        classes = ProjectManagerApplication.class)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;
    private ReleaseEntity releaseEntity;
    private UserEntity userEntity;
    private ProjectEntity projectEntity;
    private RoleEntity roleEntity;
    private TaskEntity taskEntity;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReleaseRepository releaseRepository;


    @BeforeAll
    void prepare() {
        roleEntity = new RoleEntity(1, "oleg");
        releaseEntity = new ReleaseEntity(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));
        projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.IN_PROGRESS, StatusPay.PAID);
        userEntity = new UserEntity(1, "Oleg", "Olegov", "password", roleEntity);
        taskEntity = new TaskEntity(1, "velo", "add velo", projectEntity, StatusTask.IN_PROGRESS, userEntity, userEntity, releaseEntity, 2,
                LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2021, 8, 8, 14, 0));
        taskRepository.save(taskEntity);
    }

    @Test
    void TaskRequestDtoMappingEntity() {
        TaskRequestDto taskRequestDto = new TaskRequestDto(1, "velo", "add velo", 1, StatusTask.IN_PROGRESS, 1, 1, 1, 2,
                LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2021, 8, 8, 14, 0));
//        Mockito.when(projectRepository.findById(1)).thenReturn(Optional.of(projectEntity));
//        Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(userEntity));
//        Mockito.when(releaseRepository.findById(1)).thenReturn(Optional.of(releaseEntity));
//        ReflectionTestUtils.setField(taskMapper, "projectRepository", projectRepository);
//        ReflectionTestUtils.setField(taskMapper, "userRepository", userRepository);
//        ReflectionTestUtils.setField(taskMapper, "releaseRepository", releaseRepository);

        TaskEntity taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);

//        Mockito.verify(projectRepository, Mockito.times(1)).findById(1);
//        Mockito.verify(userRepository, Mockito.times(2)).findById(1);
//        Mockito.verify(releaseRepository, Mockito.times(1)).findById(1);
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
//        TaskEntity taskEntity = new TaskEntity(1, "velo", "add velo", projectEntity, StatusTask.DONE, userEntity, userEntity, releaseEntity, 2,
//                LocalDateTime.of(2021, 8, 8, 12, 0),
//                LocalDateTime.of(2021, 8, 8, 14, 0));

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
