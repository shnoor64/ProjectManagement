package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserResponseDto {


    @Schema(description = "ID пользователя")
    private int userId;

    @Schema(description = "Имя пользователя")
    private String name;

    @Schema(description = "Фамилия пользователя")
    private String surname;

    @Schema(description = "Роль")
    private RoleResponseDto role;

    public UserResponseDto(int userId, String name, String surname, RoleResponseDto role) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public UserResponseDto() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public RoleResponseDto getRole() {
        return role;
    }

    public void setRole(RoleResponseDto role) {
        this.role = role;
    }
}
