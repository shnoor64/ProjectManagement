package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Tag(name = "Управление задачами")
@RequestMapping("/api/projectManagement")
@RestController
public class ProjectManagementController {

    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        TaskResponseDto task1 = new TaskResponseDto("task1", "Создать схему БД", 5,"BACKLOG", 6, 7,4,null, LocalDateTime.of(2021, Month.JANUARY, 12,14,15),LocalDateTime.of(2021, Month.AUGUST, 18,8,0));
        TaskResponseDto task2 = new TaskResponseDto("task2", "Прописать DTO", 5,"BACKLOG", 6, 7,4,null, LocalDateTime.of(2021, Month.JANUARY, 12,14,15),LocalDateTime.of(2021, Month.AUGUST, 18,8,0));
        TaskResponseDto task3 = new TaskResponseDto("task3", "Прописать RestController’s", 5,"BACKLOG", 6, 7,4,null, LocalDateTime.of(2021, Month.JANUARY, 12,14,15),LocalDateTime.of(2021, Month.AUGUST, 18,8,0));


        List<TaskResponseDto> results =  List.of(task1, task2, task3);
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        // добавление в БД

        return ResponseEntity.ok().body(new TaskResponseDto(requestDto.getName()
                , requestDto.getDescription()
                , requestDto.getProjectId()
                ,requestDto.getStatusTask()
                ,requestDto.getAuthorId()
                ,requestDto.getPerformerId()
                ,requestDto.getReleaseId()
                ,requestDto.getTineToComplete()
                ,requestDto.getStartTimeTask()
                ,requestDto.getEndTimeTask()));
    }

    @Operation(summary = "Обновление задачи")
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable Long id,
                                                             @RequestBody TaskRequestDto requestDto) throws IOException {
        // обновление сущности в БД
        throw new IOException();
        //return ResponseEntity.ok().body(new TaskResponseDto(requestDto.getName(), requestDto.getAuthor()));
    }

    @Operation(summary = "Удаление задачи")
    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable int id) {
        // удаление сущности из БД

        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
