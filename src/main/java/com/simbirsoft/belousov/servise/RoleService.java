package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;

import java.util.List;

public interface RoleService {

    /**
     * Метод позволяет получить все роли
     *
     * @return List<RoleResponseDto> - лист ролей
     */
    List<RoleResponseDto> getAllRoles();

    /**
     * Метод позволяет получить роль по id
     *
     * @param id - id роли
     * @return RoleResponseDto - искомая роль
     */
    RoleResponseDto getRoleById(int id);

    /**
     * Метод позволяет добавить роль
     *
     * @param roleRequestDto - добавляемая роль,
     * @return RoleResponseDto -добавленная роль
     */
    RoleResponseDto addRole(RoleRequestDto roleRequestDto);

    /**
     * Метод позволяет обновить роль
     *
     * @param roleRequestDto - роль для обновления,
     * @param id- id релиза
     * @return RoleResponseDto -обновленная роль
     */
    RoleResponseDto updateRole(RoleRequestDto roleRequestDto, int id);

    /**
     * Метод позволяет удалить роль
     *
     * @param id- id роли
     */
    void deleteRole(int id);
}
