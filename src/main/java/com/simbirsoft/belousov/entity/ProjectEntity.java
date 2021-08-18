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

    @Column(name = "description_project")
    private StatusPay descriptionProject;

    @Column(name = "customer")
    private String customer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_project")
    private StatusProject statusProject;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    private StatusPay paymentStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List <TaskEntity> tasks;

    public ProjectEntity() {

    }

    public ProjectEntity(int projectId, String name, StatusPay descriptionProject, String customer, StatusProject statusProject, StatusPay paymentStatus, List<TaskEntity> tasks) {
        this.projectId = projectId;
        this.name = name;
        this.descriptionProject = descriptionProject;
        this.customer = customer;
        this.statusProject = statusProject;
        this.paymentStatus = paymentStatus;
        this.tasks = tasks;
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

    public StatusPay getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(StatusPay paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
