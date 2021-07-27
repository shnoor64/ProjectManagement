package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.Period;

@Schema(description = "Задача")
public class TaskResponseDto {

    @Schema(description = "ID задачи")
    private int taskId;

    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String descriptionTask;

    @Schema(description = "ID проекта")
    private ProjectResponseDto projectId;

    @Schema(description = "Статус задачи")
    private StatusTask statusTask;

    @Schema(description = "ID автора задачи")
    private UserResponseDto authorId;

    @Schema(description = "ID исполнителя задачи")
    private UserResponseDto performerId;

    @Schema(description = "ID релиза")
    private ReleaseResponseDto releaseId;

    @Schema(description = "Время на исполнение задачи")
    private Period timeToComplete;

    @Schema(description = "Время начала выполнения задачи")
    private LocalDateTime startTimeTask;

    @Schema(description = "Время окончания выполнения задачи")
    private LocalDateTime endTimeTask;

    public TaskResponseDto(int taskId, String name, String description, ProjectResponseDto projectId,
                           StatusTask statusTask, UserResponseDto authorId, UserResponseDto performerId, ReleaseResponseDto releaseId,
                           Period tineToComplete, LocalDateTime startTimeTask, LocalDateTime endTimeTask) {
        this.taskId = taskId;
        this.name = name;
        this.descriptionTask = description;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
        this.timeToComplete = tineToComplete;
        this.startTimeTask = startTimeTask;
        this.endTimeTask = endTimeTask;
    }

    public TaskResponseDto() {

    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }


    public Period getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Period timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public LocalDateTime getStartTimeTask() {
        return startTimeTask;
    }

    public void setStartTimeTask(LocalDateTime startTimeTask) {
        this.startTimeTask = startTimeTask;
    }

    public LocalDateTime getEndTimeTask() {
        return endTimeTask;
    }

    public void setEndTimeTask(LocalDateTime endTimeTask) {
        this.endTimeTask = endTimeTask;
    }
}

