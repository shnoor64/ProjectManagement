package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.Period;

@Schema(description = "Задача")
public class TaskRequestDto {


    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Описание задачи")
    private String descriptionTask;

    @Schema(description = "ID проекта")
    private int projectId;

    @Schema(description = "Статус задачи")
    private String statusTask;

    @Schema(description = "ID автора задачи")
    private int authorId;

    @Schema(description = "ID исполнителя задачи")
    private int performerId;

    @Schema(description = "ID релиза")
    private int releaseId;

    @Schema(description = "Время на исполнение задачи")
    private Period tineToComplete;

    @Schema(description = "Время начала выполнения задачи")
    private LocalDateTime startTimeTask;

    @Schema(description = "Время окончания выполнения задачи")
    private LocalDateTime endTimeTask;

    public TaskRequestDto(String name, String description, int projectId, String statusTask
            , int authorId, int performerId, int releaseId, Period tineToComplete
            , LocalDateTime startTimeTask, LocalDateTime endTimeTask) {
        this.name = name;
        this.descriptionTask = description;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
        this.tineToComplete = tineToComplete;
        this.startTimeTask = startTimeTask;
        this.endTimeTask = endTimeTask;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(String statusTask) {
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

    public Period getTineToComplete() {
        return tineToComplete;
    }

    public void setTineToComplete(Period tineToComplete) {
        this.tineToComplete = tineToComplete;
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
