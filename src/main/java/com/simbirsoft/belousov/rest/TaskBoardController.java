package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
        TaskResponseDto result = taskService.updateTask(requestDto, id);
        throw new IOException();
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity partialUpdateTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok().build();
    }


}
