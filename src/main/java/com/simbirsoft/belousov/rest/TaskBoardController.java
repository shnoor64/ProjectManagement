package com.simbirsoft.belousov.rest;

import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.servise.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Tag(name = "Управление задачами")
@RequestMapping("/api/management/tasks")
@RestController
public class TaskBoardController {

    private final TaskService taskService;
    private static final Logger LOG = Logger.getLogger(TaskBoardController.class.getName());

    public TaskBoardController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить список задач")
    @GetMapping
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> results = taskService.getAllTasks();
        LOG.log(Level.INFO, "Вызван метод: getTasks");
        return ResponseEntity.ok().body(results);
    }

    @Operation(summary = "Получить задачу")
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> getTask(@PathVariable int id) {
        TaskResponseDto result = taskService.getTaskById(id);
        LOG.log(Level.INFO, "Вызван метод: getTask");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto requestDto) {
        TaskResponseDto result = taskService.addTask(requestDto);
        LOG.log(Level.INFO, "Вызван метод: createTask");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Обновить задачу")
    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> partialUpdateTask(@PathVariable int id,
                                                             @RequestBody TaskRequestDto requestDto){
        TaskResponseDto result=taskService.updateTask(requestDto, id);
        LOG.log(Level.INFO, "Вызван метод: partialUpdateTask");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity partialDeleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        LOG.log(Level.INFO, "Вызван метод: partialDeleteTask");
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Обновить исполнителя задачи")
    @PutMapping(value = "/{id}/user/{performerId}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> updatePerformerTaskById(@PathVariable int id,
                                                                   @PathVariable int performerId) throws IOException {
        taskService.updatePerformerTask(id, performerId);
        LOG.log(Level.INFO, "Вызван метод: updatePerformerTaskById");
        throw new IOException();
    }

    @Operation(summary = "Обновить статус задачи")
    @PutMapping(value = "/{id}/{statusTask}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> updateStatusTaskById(@PathVariable int id,
                                                                @PathVariable String statusTask) throws IOException {
        taskService.updateStatusTask(id, statusTask);
        LOG.log(Level.INFO, "Вызван метод: updateStatusTaskById");
        throw new IOException();
    }

    @Operation(summary = "Обновить релиз задачи")
    @PutMapping(value = "/{id}/release/{releaseId}")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<TaskResponseDto> updateReleaseTaskById(@PathVariable int id,
                                                                 @PathVariable int releaseId) throws IOException {
        taskService.updateReleaseTask(id, releaseId);
        LOG.log(Level.INFO, "Вызван метод: updateReleaseTaskById");
        throw new IOException();
    }

    @Operation(summary = "Обновить время для завершения задачи")
    @PutMapping(value = "/{id}/{timeToComplete}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> updateTimeToCompleteTaskById(@PathVariable int id,
                                                                        @PathVariable Period timeToComplete) throws IOException {
        taskService.updateTimeToCompleteTask(id, timeToComplete);
        LOG.log(Level.INFO, "Вызван метод: updateTimeToCompleteTaskById");
        throw new IOException();
    }

    @Operation(summary = "Обновить время старта задачи")
    @PutMapping(value = "/{id}/{startTimeTask}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<TaskResponseDto> updateStartTimeTaskById(@PathVariable int id,
                                                                   @PathVariable LocalDateTime startTimeTask) throws IOException {
        taskService.updateStartTimeTask(id, startTimeTask);
        LOG.log(Level.INFO, "Вызван метод: updateStartTimeTaskById");
        throw new IOException();
    }

    @Operation(summary = "Показать количество задач, не завершившихся в заданный релиз")
    @GetMapping(value = "/{releaseId}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<Integer> showNumberOutstandingTaskByReleaseId(@PathVariable int releaseId) {
        int result = taskService.showNumberOutstandingTask(releaseId);
        LOG.log(Level.INFO, "Вызван метод: showNumberOutstandingTaskByReleaseId");
        return ResponseEntity.ok().body(result);
    }

    @Operation(summary = "Получить список задач, не завершившихся в заданный релиз")
    @GetMapping(value = "/release/{releaseId}")
    @PreAuthorize("hasAnyRole('admin','user')")
    public ResponseEntity<List<TaskResponseDto>> showAllOutstandingTasksByReleaseId(@PathVariable int releaseId) {
        List<TaskResponseDto> results = taskService.showAllOutstandingTasks(releaseId);
        LOG.log(Level.INFO, "Вызван метод: showAllOutstandingTasksByReleaseId");
        return ResponseEntity.ok().body(results);
    }
    @Operation(summary = "Получить отсортированный список задач")
    @GetMapping(value = "/filter")
    @PreAuthorize("hasAnyRole('admin','user')")
//    public ResponseEntity<List<TaskResponseDto>> showTaskSort(@PathVariable String taskName) {
    public ResponseEntity<List<TaskResponseDto>> showTaskSort(@RequestBody String taskName, int taskRelease, String taskAuthor,String taskPerformer) {
        List<TaskResponseDto> results = taskService.getAllTaskSort(taskName, taskRelease, taskAuthor, taskPerformer );
        LOG.log(Level.INFO, "Вызван метод: showTaskByName");
        return ResponseEntity.ok().body(results);
    }
}