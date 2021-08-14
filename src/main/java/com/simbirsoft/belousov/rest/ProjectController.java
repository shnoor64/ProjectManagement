package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.servise.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag(name = "Управление проектами")
@RequestMapping("/api/management/projects")
@RestController
public class ProjectController {
    private static final Logger LOG = Logger.getLogger(ProjectController.class.getName());

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Получить список проектов")
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {

        List<ProjectResponseDto> results = projectService.getAllProjects();
        LOG.log(Level.INFO, "Вызван метод: getProjects");
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить проект")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable int id) {
        ProjectResponseDto result = projectService.getProjectById(id);
        LOG.log(Level.INFO, "Вызван метод: getProject");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto result = projectService.addProject(requestDto);
        LOG.log(Level.INFO, "Вызван метод: createProject");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить проект")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable int id,
                                                                   @RequestBody ProjectRequestDto requestDto){
        ProjectResponseDto result = projectService.updateProject(requestDto, id);
        LOG.log(Level.INFO, "Вызван метод: partialUpdateProject");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialDeleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        LOG.log(Level.INFO, "Вызван метод: partialDeleteProject");
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить статус проекта")
    @PutMapping(value = "/{id}/{status}")
    public ResponseEntity<ProjectResponseDto> updateStatusProjectById(@PathVariable int id,
                                                                      @PathVariable String status) {
        ProjectResponseDto result = projectService.updateStatusProject(id, status);
        LOG.log(Level.INFO, "Вызван метод: updateStatusProjectById");
        return ResponseEntity.ok().body(result);
    }

}
