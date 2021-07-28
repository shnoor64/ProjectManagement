package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.mappers.TaskMapperImpl;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private TaskMapperImpl taskMapper;

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
        taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskRepository.delete(taskEntity);
    }
}