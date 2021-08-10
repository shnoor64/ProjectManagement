package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача из фильтра")
public class TaskFilterRequestDto {

    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Проект")
    private int projectId;

    @Schema(description = "Статус задачи")
    private StatusTask statusTask;

    @Schema(description = "Автор задачи")
    private int authorId;

    @Schema(description = "Исполнитель задачи")
    private int performerId;

    @Schema(description = "Релиз")
    private int releaseId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public TaskFilterRequestDto(String name, int projectId, StatusTask statusTask, int authorId, int performerId, int releaseId) {
        this.name = name;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
    }

    public void setReleaseId(int releaseId) {
        this.releaseId = releaseId;
    }
}
