package com.simbirsoft.belousov.entity;

import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "description_project") //теперь эта колонка хранит статус оплаты проекта
    private StatusPay descriptionProject;

    @Column(name = "customer")
    private String customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_project")
    private StatusProject statusProject;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List <TaskEntity> tasks;

    public ProjectEntity(int projectId, String name, StatusPay descriptionProject, String customer, StatusProject statusProject) {
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

    public StatusPay getDescriptionProject() {
        return descriptionProject;
    }

    public void setDescriptionProject(StatusPay descriptionProject) {
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
