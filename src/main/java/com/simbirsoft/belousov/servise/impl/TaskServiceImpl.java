package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.mappers.ReleaseMapperImpl;
import com.simbirsoft.belousov.mappers.TaskMapperImpl;
import com.simbirsoft.belousov.mappers.UserMapperImpl;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapperImpl taskMapper;
    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;
    private final ReleaseRepository releaseRepository;
    private final ReleaseMapperImpl releaseMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskMapperImpl taskMapper, UserRepository userRepository, UserMapperImpl userMapper, ReleaseRepository releaseRepository, ReleaseMapperImpl releaseMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;

        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
    }

    @Transactional
    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<TaskResponseDto> taskResponseDtoList = new ArrayList<>();
        List<TaskEntity> taskEntityList = taskRepository.findAll();
        return taskEntityList
                .stream()
                .map(taskEntity -> taskMapper.taskEntityToResponseDto(taskEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public TaskResponseDto getTaskById(int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        TaskEntity taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskRepository.delete(taskEntity);
    }

    @Override
    public TaskResponseDto updatePerformerTask(int taskId, int performerId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        UserEntity performerEntity = userRepository.findById(performerId).orElseThrow(() -> new NoSuchException("Пользователь не найден"));
        taskEntity.setPerformerId(performerEntity);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Override
    public TaskResponseDto updateStatusTask(TaskRequestDto taskRequestDto, int id) {
        return null;
    }

    @Override
    public TaskResponseDto updateReleaseTask(int taskId, int releaseId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        ReleaseEntity releaseEntity = releaseRepository.findById(releaseId).orElseThrow(() -> new NoSuchException("Релиз не найден"));
        taskEntity.setReleaseId(releaseEntity);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Override
    public TaskResponseDto updateTimeToCompleteTask(int taskId, Period timeToComplete) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskEntity.setTimeToComplete(timeToComplete);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Override
    public TaskResponseDto updateStartTimeTask(int taskId, LocalDateTime startTimeTask) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskEntity.setStartTimeTask(startTimeTask);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Override
    public int showNumberOutstandingTask(int releaseId) {
        return taskRepository.countAllOutstandingTasksByRelease(releaseId);
    }

    @Override
    public List<TaskEntity> showAllOutstandingTasksByRelease(int releaseId) {
        return showAllOutstandingTasksByRelease(releaseId);
    }
}