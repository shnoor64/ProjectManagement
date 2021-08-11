package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusTask;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача из фильтра")
public class TaskFilterRequestDto {

    @Schema(description = "Имя задачи")
    private String name;

    @Schema(description = "Проект")
    private String project;

    @Schema(description = "Статус задачи")
    private StatusTask statusTask;

    @Schema(description = "Автор задачи")
    private String author;

    @Schema(description = "Исполнитель задачи")
    private String performer;

    @Schema(description = "Релиз")
    private int release;

    public TaskFilterRequestDto(String name) {
        this.name = name;
    }

    public TaskFilterRequestDto(String name, String project, StatusTask statusTask, String author, String performer, int release) {
        this.name = name;
        this.project = project;
        this.statusTask = statusTask;
        this.author = author;
        this.performer = performer;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }
}