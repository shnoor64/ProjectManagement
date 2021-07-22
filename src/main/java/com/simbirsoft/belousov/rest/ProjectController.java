package com.simbirsoft.belousov.rest;


import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchExeption;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.List;

@Tag(name = "Управление проектами")
@RequestMapping("/api/management")
@RestController
public class ProjectController {
    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/projects")
    public ResponseEntity<List<ProjectResponseDto>> getProjects() {
        ProjectResponseDto project1 = new ProjectResponseDto(1, "Банк Рога и копыта", "Приложение для банка", "Заказчик", "IN_PROGRESS");
        ProjectResponseDto project2 = new ProjectResponseDto(2, "Банк Рога и копыта", "Приложение для суши", "Заказчик", "IN_PROGRESS");


        List<ProjectResponseDto> results = List.of(project1, project2);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить проект")
    @GetMapping(value = "/projects/{id}")
    public ResponseEntity<ProjectResponseDto> getProject(@PathVariable int id,
                                                         @RequestBody ProjectRequestDto requestDto) {
        ProjectResponseDto project1 = new ProjectResponseDto(1, "Банк Рога и копыта", "Приложение для банка", "Заказчик", "IN_PROGRESS");
        ProjectResponseDto project2 = new ProjectResponseDto(2, "Банк Рога и копыта", "Приложение для суши", "Заказчик", "IN_PROGRESS");

        //Времянка, перепешу после создания сервиса
        List<ProjectResponseDto> resultsList = List.of(project1, project2);
        ProjectResponseDto result = null;
        for (ProjectResponseDto itVar : resultsList) {
            if (itVar.getProjectId() == id) {
                result = itVar;
            }

        }
//        if (result==null){
//            throw new NoSuchExeption("Не найден запрашиваемый объект с ID ="+id);
//        }
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/projects")
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
    @PutMapping(value = "/projects/{id}")
    public ResponseEntity<ProjectResponseDto> partialUpdateProject(@PathVariable int id,
                                                                   @RequestBody ProjectRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/projects/{id}")
    public ResponseEntity partialUpdateProject(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }


}
