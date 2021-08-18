package com.simbirsoft.belousov.rest.dto;

import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;

@Schema(description = "Проект")
public class ProjectResponseDto {

    @Schema(description = "ID проекта")
    private int projectId;

    @Schema(description = "Имя проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private StatusPay descriptionProject;

    @Schema(description = "Заказчик")
    private String customer;

    @Schema(description = "Статус проекта")
    private StatusProject statusProject;

    @Column(name = "payment_status")
    private StatusPay paymentStatus;

    public ProjectResponseDto(int projectId, String name, StatusPay descriptionProject, String customer, StatusProject statusProject, StatusPay paymentStatus) {
        this.projectId = projectId;
        this.name = name;
        this.descriptionProject = descriptionProject;
        this.customer = customer;
        this.statusProject = statusProject;
        this.paymentStatus = paymentStatus;
    }

    public ProjectResponseDto() {

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

    public StatusPay getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(StatusPay paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
