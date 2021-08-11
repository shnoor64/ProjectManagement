package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.TaskFilterRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();

    TaskResponseDto getTaskById(int taskId);

    TaskResponseDto addTask(TaskRequestDto taskRequestDto);

    TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int taskId);

    void deleteTask(int taskId);

    TaskResponseDto updatePerformerTask(int taskId, int performerId);

    TaskResponseDto updateStatusTask(int taskId, String statusTask);

    TaskResponseDto updateReleaseTask(int taskId, int releaseId);

    TaskResponseDto updateTimeToCompleteTask(int taskId, Period tineToComplete);

    TaskResponseDto updateStartTimeTask(int taskId, LocalDateTime startTimeTask);

    //    TaskResponseDto calculatedTimeEndTaskTask(TaskRequestDto taskRequestDto, int taskId);

    int showNumberOutstandingTask(int releaseId);

    List<TaskResponseDto> showAllOutstandingTasks(int releaseId);

    LocalDateTime getPlannedEndTimeTask(LocalDateTime startTimeTask, Period timeToComplete);

//    List <TaskResponseDto> getAllTaskSort (String taskName, int release, String author, String performer);
List <TaskResponseDto> getAllTaskSort (TaskFilterRequestDto taskFilterRequestDto);
}
