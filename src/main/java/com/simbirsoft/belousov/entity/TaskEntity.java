package com.simbirsoft.belousov.entity;

import com.simbirsoft.belousov.enums.StatusTask;

import javax.persistence.*;
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

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "project_id")
    private ProjectEntity projectId;

    @Column(name = "status_task")
    private StatusTask statusTask;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "author_id")
    private UserEntity authorId;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "performer_id")
    private UserEntity performerId;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "release_id")
    private ReleaseEntity releaseId;

    @Column(name = "time_to_complete")
    private Period tineToComplete;

    @Column(name = "start_time_task")
    private LocalDateTime startTimeTask;

    @Column(name = "end_time_task")
    private LocalDateTime endTimeTask;

    public TaskEntity(int taskId, String name, String descriptionTask
            , ProjectEntity projectId, StatusTask statusTask
            , UserEntity authorId, UserEntity performerId
            , ReleaseEntity releaseId, Period tineToComplete
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

    public ProjectEntity getProjectId() {
        return projectId;
    }

    public void setProjectId(ProjectEntity projectId) {
        this.projectId = projectId;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public UserEntity getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UserEntity authorId) {
        this.authorId = authorId;
    }

    public UserEntity getPerformerId() {
        return performerId;
    }

    public void setPerformerId(UserEntity performerId) {
        this.performerId = performerId;
    }

    public ReleaseEntity getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(ReleaseEntity releaseId) {
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
