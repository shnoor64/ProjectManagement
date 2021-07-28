package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return null;
    }

    @Override
    public TaskResponseDto getTaskById(int id) {
        return null;
    }

    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto) {
        return null;
    }

    @Override
    public void deleteTask(int id) {

    }
}
