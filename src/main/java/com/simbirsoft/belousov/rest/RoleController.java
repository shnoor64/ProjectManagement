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
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag(name = "Управление ролями")
@RequestMapping("/api/management/roles")
@RestController
public class RoleController {
    private final RoleService roleService;
    private static final Logger LOG = Logger.getLogger(RoleController.class.getName());

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(summary = "Получить список ролей")
    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getRoles() {
        List<RoleResponseDto> results = roleService.getAllRoles();
        LOG.log(Level.INFO, "Вызван метод: getRoles");
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить роль")
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable int id) {
        RoleResponseDto result = roleService.getRoleById(id);
        LOG.log(Level.INFO, "Вызван метод: getRole");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить роль")
    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto requestDto) {
        RoleResponseDto result = roleService.addRole(requestDto);
        LOG.log(Level.INFO, "Вызван метод: createRole");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить роль")
    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> partialUpdateRole(@PathVariable int id,
                                                             @RequestBody RoleRequestDto requestDto) throws IOException {
        RoleResponseDto result = roleService.updateRole(requestDto, id);
        LOG.log(Level.INFO, "Вызван метод: partialUpdateRole");
        throw new IOException();
    }

    @Operation(summary = "Удалить роль")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialDeleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        LOG.log(Level.INFO, "Вызван метод: partialDeleteRole");
        return ResponseEntity.ok().build();
    }


}
