package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;

import com.simbirsoft.belousov.servise.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Tag(name = "Управление проектами")
@RequestMapping("/api/management/projects")
@RestController
public class ProjectController {

    private ProjectService projectService;

    @Operation(summary = "Получить список проектов")
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {

        List<ProjectResponseDto> results = projectService.getAllProjects();
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить проект")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable int id) {
        ProjectResponseDto result = projectService.getProjectById(id);
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить проект")
    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto result = projectService.addProject(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить проект")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable int id,
                                                                   @RequestBody ProjectRequestDto requestDto) throws IOException {
        ProjectResponseDto result = projectService.updateProject(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateProject(@PathVariable int id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }


}
