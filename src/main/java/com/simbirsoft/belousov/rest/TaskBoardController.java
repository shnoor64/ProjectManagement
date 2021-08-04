package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Tag(name = "Управление задачами")
@RequestMapping("/api/management/tasks")
@RestController
public class TaskBoardController {

    private final TaskService taskService;

    public TaskBoardController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить список задач")
    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> results = taskService.getAllTasks();
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить задачу")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable int id) {
        TaskResponseDto result = taskService.getTaskById(id);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        TaskResponseDto result = taskService.addTask(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить задачу")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable int id,
                                                             @RequestBody TaskRequestDto requestDto) throws IOException {
        taskService.updateTask(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить исполнителя задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updatePerformerTaskById(@PathVariable int id,
                                                                   @RequestBody int performerId) throws IOException {
        taskService.updatePerformerTask(id, performerId);
        throw new IOException();
    }

    @Operation(summary = "Обновить статус задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updateStatusTaskById(@PathVariable int id,
                                                                @RequestBody String statusTask) throws IOException {
        taskService.updateStatusTask(id, statusTask);
        throw new IOException();
    }

    @Operation(summary = "Обновить релиз задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updateReleaseTaskById(@PathVariable int id,
                                                                 @RequestBody int releaseId) throws IOException {
        taskService.updateReleaseTask(id, releaseId);
        throw new IOException();
    }

    @Operation(summary = "Обновить время для завершения задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updateTimeToCompleteTaskById(@PathVariable int id,
                                                                        @RequestBody Period timeToComplete) throws IOException {
        taskService.updateTimeToCompleteTask(id, timeToComplete);
        throw new IOException();
    }

    @Operation(summary = "Обновить время старта задачи")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updateStartTimeTaskById(@PathVariable int id,
                                                                   @RequestBody LocalDateTime startTimeTask) throws IOException {
        taskService.updateStartTimeTask(id, startTimeTask);
        throw new IOException();
    }

    @Operation(summary = "Показать количество задач, не завершившихся в заданный релиз")
    @GetMapping(value = "/{releaseId}")
    public ResponseEntity<Integer> showNumberOutstandingTaskByReleaseId(@PathVariable int releaseId) {
        int result = taskService.showNumberOutstandingTask(releaseId);
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Получить список задач, не завершившихся в заданный релиз")
    @GetMapping(value = "/{releaseId}")
    public ResponseEntity<List<TaskResponseDto>> showAllOutstandingTasksByReleaseId(@PathVariable int releaseId) {
        List<TaskResponseDto> results = taskService.showAllOutstandingTasks(releaseId);
        return ResponseEntity.ok().body(results);
    }
}