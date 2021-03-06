package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Задача")
public class TaskRequestDto {

    @Schema(description = "ID задачи")
    private int taskId;

    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String descriptionTask;

    @Schema(description = "ID проекта")
    private int projectId;

    @Schema(description = "Статус задачи")
    private StatusTask statusTask;

    @Schema(description = "ID автора задачи")
    private int authorId;

    @Schema(description = "ID исполнителя задачи")
    private int performerId;

    @Schema(description = "ID релиза")
    private int releaseId;

    @Schema(description = "Время на исполнение задачи")
    private int timeToComplete;

    @Schema(description = "Время начала выполнения задачи")
    private LocalDateTime startTimeTask;

    @Schema(description = "Время окончания выполнения задачи")
    private LocalDateTime endTimeTask;

    public TaskRequestDto(int taskId, String name, String descriptionTask, int projectId, StatusTask statusTask
            , int authorId, int performerId, int releaseId, int timeToComplete
            , LocalDateTime startTimeTask, LocalDateTime endTimeTask) {
        this.taskId = taskId;
        this.name = name;
        this.descriptionTask = descriptionTask;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
        this.timeToComplete = timeToComplete;
        this.startTimeTask = startTimeTask;
        this.endTimeTask = endTimeTask;
    }

    public TaskRequestDto() {
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPerformerId() {
        return performerId;
    }

    public void setPerformerId(int performerId) {
        this.performerId = performerId;
    }

    public int getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(int timeToComplete) {
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