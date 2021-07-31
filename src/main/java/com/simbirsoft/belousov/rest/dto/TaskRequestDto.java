package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.Period;

@Schema(description = "Задача")
public class TaskRequestDto {

    @Schema(description = "ID задачи")
    private int taskId;

    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String descriptionTask;

    @Schema(description = "ID проекта")
    private ProjectRequestDto projectId;

    @Schema(description = "Статус задачи")
    private StatusTask statusTask;

    @Schema(description = "ID автора задачи")
    private UserRequestDto authorId;

    @Schema(description = "ID исполнителя задачи")
    private UserRequestDto performerId;

    @Schema(description = "ID релиза")
    private ReleaseRequestDto releaseId;

    @Schema(description = "Время на исполнение задачи")
    private Period timeToComplete;

    @Schema(description = "Время начала выполнения задачи")
    private LocalDateTime startTimeTask;

    @Schema(description = "Время окончания выполнения задачи")
    private LocalDateTime endTimeTask;

    public TaskRequestDto(int taskId, String name, String descriptionTask, ProjectRequestDto projectId, StatusTask statusTask
            , UserRequestDto authorId, UserRequestDto performerId, ReleaseRequestDto releaseId, Period tineToComplete
            , LocalDateTime startTimeTask, LocalDateTime endTimeTask) {
        this.taskId = taskId;
        this.name = name;
        this.descriptionTask = descriptionTask;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
        this.timeToComplete = tineToComplete;
        this.startTimeTask = startTimeTask;
        this.endTimeTask = endTimeTask;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return descriptionTask;
    }

    public void setDescription(String description) {
        this.descriptionTask = description;
    }

    public ProjectRequestDto getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectRequestDto projectId) {
        this.projectId = projectId;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public UserRequestDto getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UserRequestDto authorId) {
        this.authorId = authorId;
    }

    public UserRequestDto getPerformerId() {
        return performerId;
    }

    public void setPerformerId(UserRequestDto performerId) {
        this.performerId = performerId;
    }

    public ReleaseRequestDto getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseRequestDto releaseId) {
        this.releaseId = releaseId;
    }

    public Period getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(Period timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public Period getTineToComplete() {
        return timeToComplete;
    }

    public void setTineToComplete(Period tineToComplete) {
        this.timeToComplete = tineToComplete;
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