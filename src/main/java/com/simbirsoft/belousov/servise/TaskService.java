package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();

    TaskResponseDto getTaskById(int id);

    TaskResponseDto addTask(TaskRequestDto taskRequestDto);

    TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id);

    void deleteTask(int id);


    TaskResponseDto updatePerformerTask(int taskId, int performerId);

    TaskResponseDto updateStatusTask(TaskRequestDto taskRequestDto, int id);

    TaskResponseDto updateReleaseTask(int taskId, int releaseId);

    TaskResponseDto updateTimeToCompleteTask(int taskId, Period tineToComplete);

    TaskResponseDto updateStartTimeTask(int taskId, LocalDateTime startTimeTask);
//    TaskResponseDto calculatedTimeEndTaskTask(TaskRequestDto taskRequestDto, int id);
//    int showNumberOutstandingTask(int releaseId);


}
