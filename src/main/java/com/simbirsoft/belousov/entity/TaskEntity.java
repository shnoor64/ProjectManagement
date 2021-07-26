package com.simbirsoft.belousov.entity;

import com.simbirsoft.belousov.enums.StatusTask;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;

    @Column(name = "name")
    private String name;

    @Column(name = "description_task")
    private String descriptionTask;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "status_task")
    private StatusTask statusTask;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "performer_id")
    private int performerId;

    @Column(name = "release_id")
    private int releaseId;

    @Column(name = "tine_to_complete")
    private Period tineToComplete;

    @Column(name = "start_time_task")
    private LocalDateTime startTimeTask;

    @Column(name = "end_time_task")
    private LocalDateTime endTimeTask;

    public TaskEntity(int taskId, String name, String descriptionTask, int projectId, StatusTask statusTask
            , int authorId, int performerId, int releaseId, Period tineToComplete
            , LocalDateTime startTimeTask, LocalDateTime endTimeTask) {
        this.taskId = taskId;
        this.name = name;
        this.descriptionTask = descriptionTask;
        this.projectId = projectId;
        this.statusTask = statusTask;
        this.authorId = authorId;
        this.performerId = performerId;
        this.releaseId = releaseId;
        this.tineToComplete = tineToComplete;
        this.startTimeTask = startTimeTask;
        this.endTimeTask = endTimeTask;
    }

    public TaskEntity() {

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
