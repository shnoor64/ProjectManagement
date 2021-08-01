package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.servise.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление ролями")
@RequestMapping("/api/management/roles")
@RestController
public class RoleController {
private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(summary = "Получить список ролей")
    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getRoles() {

        List<RoleResponseDto> results = roleService.getAllRoles();
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить роль")
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable int id) {
        RoleResponseDto result = roleService.getRoleById(id);
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить роль")
    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto requestDto) {
        RoleResponseDto result = roleService.addRole(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить роль")
    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> partialUpdateRole(@PathVariable int id,
                                                                   @RequestBody RoleRequestDto requestDto) throws IOException {
        RoleResponseDto result = roleService.updateRole(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить роль")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok().build();
    }


}
