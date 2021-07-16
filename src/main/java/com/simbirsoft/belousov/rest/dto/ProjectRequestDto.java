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
}
