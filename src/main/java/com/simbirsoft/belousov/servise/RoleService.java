package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> getAllRoles();

    RoleResponseDto getRoleById(int id);

    RoleResponseDto addRole(RoleRequestDto roleRequestDto);

    RoleResponseDto updateRole(RoleRequestDto roleRequestDto);

    void deleteRole(int id);
}
