package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.TaskFilterRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {

    /**
     * Метод позволяет получить все задачи
     *
     * @return List<TaskResponseDto> - лист задач
     */
    List<TaskResponseDto> getAllTasks();

    /**
     * Метод позволяет получить задачу по id
     *
     * @param taskId - id задачи
     * @return TaskResponseDto - искомая задача
     */
    TaskResponseDto getTaskById(int taskId);

    /**
     * Метод позволяет добавить задачу
     *
     * @param taskRequestDto - добавляемая задача,
     * @return TaskResponseDto -добавленная задача
     */
    TaskResponseDto addTask(TaskRequestDto taskRequestDto);

    /**
     * Метод позволяет обновить задачу
     *
     * @param taskRequestDto - обновленная задача,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int taskId);

    /**
     * Метод позволяет удалить задачу
     *
     * @param taskId- id задачи
     */
    void deleteTask(int taskId);

    /**
     * Метод позволяет обновить исполнителя задачи
     *
     * @param performerId - исполнитель задачи,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updatePerformerTask(int taskId, int performerId);

    /**
     * Метод позволяет обновить статус задачи
     *
     * @param statusTask - статус задачи,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updateStatusTask(int taskId, String statusTask);

    /**
     * Метод позволяет обновить релиз задачи
     *
     * @param releaseId - релиз задачи,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updateReleaseTask(int taskId, int releaseId);

    /**
     * Метод позволяет обновить время на исполнение задачи
     *
     * @param timeToComplete - время на исполнение задачи,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updateTimeToCompleteTask(int taskId, int timeToComplete);

    /**
     * Метод позволяет обновить время старта задачи
     *
     * @param startTimeTask - начало задачи,
     * @param taskId- id задачи
     * @return TaskResponseDto -обновленная задача
     */
    TaskResponseDto updateStartTimeTask(int taskId, LocalDateTime startTimeTask);

    //    TaskResponseDto calculatedTimeEndTaskTask(TaskRequestDto taskRequestDto, int taskId);

    /**
     * Метод позволяет получить число задач, которые не выполненны в заданном релизе
     *
     * @param releaseId - релиз задач
     * @return int - число задач
     */
    int showNumberOutstandingTask(int releaseId);

    /**
     * Метод позволяет получить лист задач, которые не выполненны в заданном релизе
     *
     * @param releaseId - релиз задач
     * @return List<TaskResponseDto> - лист задач
     */
    List<TaskResponseDto> showAllOutstandingTasks(int releaseId);

    /**
     * Метод позволяет получить плановое вреемя завершения задачи
     *
     * @param startTimeTask - начало задачи,
     * @param timeToComplete- время на исполение залдачи
     * @return LocalDateTime Дата и время окончания задачи
     */
    LocalDateTime getPlannedEndTimeTask(LocalDateTime startTimeTask, int timeToComplete);

    /**
     * Метод позволяет получить задачу по фильтру
     *
     * @param taskFilterRequestDto - запрос с параметрами фильтра
     * @return List<TaskResponseDto> - личт задач
     */
    List<TaskResponseDto> getAllTaskSort(TaskFilterRequestDto taskFilterRequestDto);

    /**
     * Метод позволяет добавить задачи из CSV файла
     *
     * @param file - CSV файл
     * @return List<TaskResponseDto> - личт задач
     */
    List<TaskResponseDto> parsTaskFromCsv (MultipartFile file) throws IOException;
}
