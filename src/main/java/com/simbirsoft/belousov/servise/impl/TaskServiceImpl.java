package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    @Override
    public List<TaskResponseDto> getAllTasks() {
        return null;
    }

    @Transactional
    @Override
    public TaskResponseDto getTaskById(int id) {
        return null;
    }

    @Transactional
    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public void deleteTask(int id) {

    }
}
