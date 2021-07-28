package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Tag(name = "Управление проектами")
@RequestMapping("/api/management/projects")
@RestController
public class ProjectController {
    @Operation(summary = "Получить список проектов")
    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        ProjectResponseDto project1 = new ProjectResponseDto(1, "Банк Рога и копыта", "Приложение для банка", "Заказчик", StatusProject.IN_PROGRESS);
        ProjectResponseDto project2 = new ProjectResponseDto(2, "Банк Рога и копыта", "Приложение для суши", "Заказчик", StatusProject.CLOSED);


        List<ProjectResponseDto> results = List.of(project1, project2);
        return ResponseEntity.ok().body(results);

    }

    @Operation(summary = "Получить проект")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable int id) {
        ProjectResponseDto project1 = new ProjectResponseDto(1, "Банк Рога и копыта", "Приложение для банка", "Заказчик", StatusProject.IN_PROGRESS);
        ProjectResponseDto project2 = new ProjectResponseDto(2, "Банк Рога и копыта", "Приложение для суши", "Заказчик", StatusProject.CLOSED);

        //Времянка, перепешу после создания сервиса
        ProjectResponseDto result;
        result = Stream.of(project1, project2)
                .filter(projectResponseDto -> projectResponseDto.getProjectId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchException("Проект не найден"));
        return ResponseEntity.ok().body(result);

    }

    @Operation(summary = "Добавить проект")
    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto requestDto) {
        return ResponseEntity.ok().body(new ProjectResponseDto(
                requestDto.getProjectId(),
                requestDto.getName(),
                requestDto.getDescriptionProject(),
                requestDto.getCustomer(),
                requestDto.getStatusProject()
        ));
    }

    @Operation(summary = "Обновить проект")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable int id,
                                                                   @RequestBody ProjectRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateProject(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }


}
