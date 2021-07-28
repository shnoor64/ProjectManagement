package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление ролями")
@RequestMapping("/api/management/roles")
@RestController
public class RoleController {

    private RoleService roleService;

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
