package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Tag(name = "Управление ролями")
@RequestMapping("/api/projectManagement")
@RestController
public class RoleController {
    @Operation(summary = "Получить список ролей")
    @GetMapping(value = "/roles")
    public ResponseEntity<List<RoleResponseDto>> getRoles() {
        RoleResponseDto  role1= new RoleResponseDto(3,"developer");
        RoleResponseDto  role2= new RoleResponseDto(3,"time lead");


        List<RoleResponseDto> results = List.of(role1,role2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить роль")
    @PostMapping(value = "/roles")
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto requestDto) {
        return ResponseEntity.ok().body(new RoleResponseDto(
                requestDto.getRoleId(),
                requestDto.getName()
        ));
    }

    @Operation(summary = "Обновить роль")
    @PutMapping(value = "/roles/{id}")
    public ResponseEntity<RoleResponseDto> partialUpdateRole(@PathVariable int id,
                                                                    @RequestBody RoleRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить роль")
    @DeleteMapping(value = "/roles/{id}")
    public ResponseEntity partialUpdateRole(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

}

