package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление проектами")
@RequestMapping("/api/projectManagement")
@RestController
public class ProjectController {
    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/projects")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        ProjectResponseDto  project1= new ProjectResponseDto(1,"Банк Рога и копыта", "Приложение для банка","Заказчик","IN_PROGRESS");


        List<ProjectResponseDto> results = List.of(project1);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/projects")
    public ResponseEntity<ProjectResponseDto> createProjects(@RequestBody ProjectResponseDto requestDto) {
        return ResponseEntity.ok().body(new ProjectResponseDto(
                requestDto.getProjectId(),
                requestDto.getName(),
                requestDto.getDescriptionProject(),
                requestDto.getCustomer(),
                requestDto.getStatusProject()
        ));
    }

    @Operation(summary = "Обновить проект")
    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProjects(@PathVariable int id,
                                                             @RequestBody ProjectResponseDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity partialUpdateProjects(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
