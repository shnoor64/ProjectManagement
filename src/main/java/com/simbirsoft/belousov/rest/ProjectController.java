package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.dto.feign.AccountHistoryResponseDto;
import com.simbirsoft.belousov.servise.BankService;
import com.simbirsoft.belousov.servise.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private final BankService bankService;

    public ProjectController(ProjectService projectService, BankService bankService) {
        this.projectService = projectService;
        this.bankService = bankService;
    }

    @Operation(summary = "Получить список проектов")
    @GetMapping
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {

        List<ProjectResponseDto> results = projectService.getAllProjects();
        LOG.log(Level.INFO, "Запрос: \"Получить список проектов\" /api/management/projects");
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить проект")
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable int id) {
        ProjectResponseDto result = projectService.getProjectById(id);
        LOG.log(Level.INFO, "Запрос: \"Получить проектв\" /api/management/projects/" + id);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto result = projectService.addProject(requestDto);
        LOG.log(Level.INFO, "Запрос: \"Добавить проект\" /api/management/projects");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить проект")
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable int id,
                                                                   @RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto result = projectService.updateProject(requestDto, id);
        LOG.log(Level.INFO, "Запрос: \"Обновить проект\" /api/management/projects/" + id);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity partialDeleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
        LOG.log(Level.INFO, "Запрос: \"Удалить проект\" /api/management/projects/" + id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить статус проекта")
    @PutMapping(value = "/{id}/{status}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<ProjectResponseDto> updateStatusProjectById(@PathVariable int id,
                                                                      @PathVariable String status) {
        ProjectResponseDto result = projectService.updateStatusProject(id, status);
        LOG.log(Level.INFO, "Запрос: \"Обновить статус проекта\" /api/management/projects/" + id + "/" + status);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Заплатить за проект")
    @PostMapping(value = "/{description}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public void payment(@PathVariable String description) {
        bankService.payProject(description);
        LOG.log(Level.INFO, "Запрос: \"Заплатить за проект\" /api/management/projects/" + description);

    }

    @Operation(summary = "Получить всю историю операций по логину")
    @GetMapping(value = "/information")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<List<AccountHistoryResponseDto>> getCustomerOperationHistory(@PathVariable String description) {
        projectService.makePayment(description);
        LOG.log(Level.INFO, "Запрос: \"Заплатить за проект\" /api/management/projects/" + description);
        List<AccountHistoryResponseDto> results = bankService.getAllHistoryAccount();
        return ResponseEntity.ok().body(results);
    }
}

