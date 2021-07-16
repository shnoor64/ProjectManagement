package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Задача")
public class ProjectRequestDto {

    @Schema(description = "Имя проекта")
    private String name;

    @Schema(description = "Описание проекта")
    private String descriptionProject;

    @Schema(description = "Заказчик")
    private String customer;

    @Schema(description = "Статус проекта")
    private String statusProject;

    public ProjectRequestDto(String name, String descriptionProject, String customer, String statusProject) {
        this.name = name;
        this.descriptionProject = descriptionProject;
        this.customer = customer;
        this.statusProject = statusProject;
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

    public String getStatusProject() {
        return statusProject;
    }

    public void setStatusProject(String statusProject) {
        this.statusProject = statusProject;
    }
}
