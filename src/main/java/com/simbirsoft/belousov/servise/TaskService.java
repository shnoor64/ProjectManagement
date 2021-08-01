package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();

    TaskResponseDto getTaskById(int id);

    TaskResponseDto addTask(TaskRequestDto taskRequestDto);

    TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id);

    void deleteTask(int id);


    TaskResponseDto updatePerformerTask(int taskId, int performerId);
//    TaskResponseDto updateStatusTask(TaskRequestDto taskRequestDto, int id);
//    TaskResponseDto updateReleaseTask(TaskRequestDto taskRequestDto, int id);
//    TaskResponseDto updateTimeToCompleteTask(TaskRequestDto taskRequestDto, int id);
//    TaskResponseDto updateStartTimeTask(TaskRequestDto taskRequestDto, int id);
//    TaskResponseDto calculatedTimeEndTaskTask(TaskRequestDto taskRequestDto, int id);
//    TaskResponseDto showOutstandingTask(TaskRequestDto taskRequestDto, int id);


}
