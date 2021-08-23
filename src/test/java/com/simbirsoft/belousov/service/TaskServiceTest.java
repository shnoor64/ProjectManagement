package com.simbirsoft.belousov.service;

import com.simbirsoft.belousov.ProjectManagerApplication;
import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@SpringBootTest(
        classes = ProjectManagerApplication.class)
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")

public class TaskServiceTest {


    private ReleaseEntity releaseEntity;
    private ProjectEntity projectEntity;
    private UserEntity userEntity;
    private TaskEntity taskEntity;

    @Autowired
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;
    private UserRepository userRepository;
    private ReleaseRepository releaseRepository;
    private TaskService taskService;


    @BeforeEach
    void prepare() {
        releaseEntity = new ReleaseEntity(1, 1, LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2022, 8, 8, 14, 0));
        projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);
        userEntity = new UserEntity(1, "Oleg", "Olegov", "password", null);
        taskEntity = new TaskEntity(1, "velo", "add velo", projectEntity, StatusTask.DONE, userEntity, userEntity, releaseEntity, 2,
                LocalDateTime.of(2021, 8, 8, 12, 0),
                LocalDateTime.of(2021, 8, 8, 14, 0));
        taskRepository.save(taskEntity);
    }

    @Test
    void InProgressStatusOfTheStartProject() {

        TaskResponseDto taskResponseDto = taskService.updateStatusTask(1, "IN_PROGRESS");

        Assertions.assertEquals(taskEntity.getStatusTask(), taskResponseDto.getStatusTask());
    }

    @Test
    void DoneStatusOfTheOldStatusInProgress() {

        TaskResponseDto taskResponseDto = taskService.updateStatusTask(1, "CLOSED");

        Assertions.assertEquals(taskEntity.getStatusTask(), taskResponseDto.getStatusTask());
    }

    @Test
    void NumberOutstandingTask() {

        int numberTask = taskService.showNumberOutstandingTask(releaseEntity.getReleaseId());

        Assertions.assertTrue(numberTask == 1);
    }
    @Test
    void SortTaskByPerformerAndRelease() {

        int numberOutstandingTask = taskService.showNumberOutstandingTask(releaseEntity.getReleaseId());

        Assertions.assertTrue(numberOutstandingTask == 1);
    }
//    @Test
//    void rerrew() {
//        Assertions.assertTrue(true);
//    }
}
