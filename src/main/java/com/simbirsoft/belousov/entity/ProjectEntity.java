package com.simbirsoft.belousov.entity;

import com.simbirsoft.belousov.enums.StatusProject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description_project")
    private String descriptionProject;

    @Column(name = "customer")
    private String customer;

    @Column(name = "status_project")
    private StatusProject statusProject;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List <TaskEntity> tasks;

    public ProjectEntity(int projectId, String name, String descriptionProject, String customer, StatusProject statusProject) {
        this.projectId = projectId;
        this.name = name;
        this.descriptionProject = descriptionProject;
        this.customer = customer;
        this.statusProject = statusProject;
    }

    public ProjectEntity() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(String descriptionProject) {
        this.descriptionProject = descriptionProject;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public StatusProject getStatusProject() {
        return statusProject;
    }

    public void setStatusProject(StatusProject statusProject) {
        this.statusProject = statusProject;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
