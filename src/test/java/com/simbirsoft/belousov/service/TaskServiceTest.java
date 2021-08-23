package com.simbirsoft.belousov.service;

import com.simbirsoft.belousov.ProjectManagerApplication;
import com.simbirsoft.belousov.entity.*;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskFilterRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(
        classes = ProjectManagerApplication.class)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceTest {
    private RoleEntity roleEntity;
    private ReleaseEntity releaseEntity;
    private ProjectEntity projectEntity;
    private UserEntity userEntity;
    private TaskEntity taskEntity;

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReleaseRepository releaseRepository;
    @Autowired
    private TaskService taskService;


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
    void InProgressStatusOfTheStartProject() {


        TaskResponseDto taskResponseDto = taskService.updateStatusTask(1, "IN_PROGRESS");

        Assertions.assertEquals(StatusTask.IN_PROGRESS, taskResponseDto.getStatusTask());
    }

    @Test
    void DoneStatusOfTheOldStatusInProgress() {

        TaskResponseDto taskResponseDto = taskService.updateStatusTask(1, "DONE");

        Assertions.assertEquals(StatusTask.DONE, taskResponseDto.getStatusTask());
    }

    @Test
    void NumberOutstandingTask() {

        int numberTask = taskService.showNumberOutstandingTask(releaseEntity.getReleaseId());

        Assertions.assertTrue(numberTask == 1);
    }

    @Test
    void SortTaskByPerformerAndRelease() {
        TaskFilterRequestDto taskFilterRequestDto = new TaskFilterRequestDto("velo", "Velodrom", StatusTask.BACKLOG, "Oleg", "Oleg", 1);

        List<TaskResponseDto> responseDtoList = taskService.getAllTaskSort(taskFilterRequestDto);

        Assertions.assertEquals(responseDtoList.size(), 1);
        Assertions.assertTrue(responseDtoList.get(0).getTaskId() == 1);

    }
}
