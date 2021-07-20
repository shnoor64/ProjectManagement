package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Tag(name = "Управление задачами")
@RequestMapping("/api/projectManagement")
@RestController
public class TaskBoardController {

    @Operation(summary = "Получить список задач")
    @GetMapping(value = "/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        TaskResponseDto task1 = new TaskResponseDto(5, "task1", "Создать схему БД", 5, StatusTask.DONE, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));
        TaskResponseDto task2 = new TaskResponseDto(6, "task2", "Прописать DTO", 5, StatusTask.BACKLOG, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));
        TaskResponseDto task3 = new TaskResponseDto(7, "task3", "Прописать RestController’s", 5, StatusTask.IN_PROGRESS, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));

        List<TaskResponseDto> results = List.of(task1, task2, task3);
        return ResponseEntity.ok().body(results);
    }


    @Operation(summary = "Получить задачу")
    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable int id,
                                                   @RequestBody TaskRequestDto requestDto) {
        TaskResponseDto task1 = new TaskResponseDto(5, "task1", "Создать схему БД", 5, StatusTask.DONE, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));
        TaskResponseDto task2 = new TaskResponseDto(6, "task2", "Прописать DTO", 5, StatusTask.BACKLOG, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));
        TaskResponseDto task3 = new TaskResponseDto(7, "task3", "Прописать RestController’s", 5, StatusTask.IN_PROGRESS, 6, 7, 4, null, LocalDateTime.of(2021, Month.JANUARY, 12, 14, 15), LocalDateTime.of(2021, Month.AUGUST, 18, 8, 0));
        //Времянка, перепешу после создания сервиса
        List<TaskResponseDto> resultsList = List.of(task1, task2,task3);
        TaskResponseDto result = null;
        for (TaskResponseDto itVar : resultsList) {
            if (itVar.getTaskId() == id) {
                result = itVar;
            }

        }
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        return ResponseEntity.ok().body(new TaskResponseDto(
                requestDto.getTaskId(),
                requestDto.getName(),
                requestDto.getDescription(),
                requestDto.getProjectId(),
                requestDto.getStatusTask(),
                requestDto.getAuthorId(),
                requestDto.getPerformerId(),
                requestDto.getReleaseId(),
                requestDto.getTineToComplete(),
                requestDto.getStartTimeTask(),
                requestDto.getEndTimeTask()
        ));
    }

    @Operation(summary = "Обновить задачу")
    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable int id,
                                                             @RequestBody TaskRequestDto requestDto) throws IOException {
        throw new IOException();
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

}
