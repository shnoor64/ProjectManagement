package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.mappers.TaskMapperImpl;
import com.simbirsoft.belousov.mappers.UserMapperImpl;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapperImpl taskMapper;
    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskMapperImpl taskMapper, UserRepository userRepository, UserMapperImpl userMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;

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
}
