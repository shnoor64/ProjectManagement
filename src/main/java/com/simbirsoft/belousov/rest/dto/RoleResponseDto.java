package com.simbirsoft.belousov.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class RoleResponseDto {
    @Schema(description = "ID роли")
    private int roleId;

    @Schema(description = "Название роли")
    private String name;

    public RoleResponseDto(int roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public RoleResponseDto() {

    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
