package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ReleaseResponseDto;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление ролями")
@RequestMapping("/api/management/roles")
@RestController
public class RoleController {
    @Operation(summary = "Получить список ролей")
    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getRoles() {
        RoleResponseDto role1 = new RoleResponseDto(3, "developer");
        RoleResponseDto role2 = new RoleResponseDto(4, "time lead");


        List<RoleResponseDto> results = List.of(role1, role2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить роль")
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> getRole(@PathVariable int id,
                                                   @RequestBody RoleRequestDto requestDto) {
        RoleResponseDto role1 = new RoleResponseDto(3, "developer");
        RoleResponseDto role2 = new RoleResponseDto(4, "time lead");
        //Времянка, перепешу после создания сервиса
        RoleResponseDto result;
        result = Stream.of(role1, role2)
                .filter(roleResponseDto -> roleResponseDto.getRoleId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchException("Роль не найдена"));
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить роль")
    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody RoleRequestDto requestDto) {
        return ResponseEntity.ok().body(new RoleResponseDto(
                requestDto.getRoleId(),
                requestDto.getName()
        ));
    }

    @Operation(summary = "Обновить роль")
    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleResponseDto> partialUpdateRole(@PathVariable int id,
                                                             @RequestBody RoleRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить роль")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateRole(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

}

