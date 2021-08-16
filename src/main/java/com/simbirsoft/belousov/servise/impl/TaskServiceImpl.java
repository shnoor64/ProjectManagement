package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ReleaseEntity;
import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.enums.StatusTask;
import com.simbirsoft.belousov.mappers.*;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskFilterRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.IncorrectlyEnteredStatusException;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.TaskService;
import com.simbirsoft.belousov.specifications.TaskSpecification;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;

    private final ReleaseRepository releaseRepository;

    private final ProjectRepository projectRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, UserRepository userRepository, ReleaseRepository releaseRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.releaseRepository = releaseRepository;
        this.projectRepository = projectRepository;
    }


    @Transactional
    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<TaskResponseDto> taskResponseDtoList = new ArrayList<>();
        List<TaskEntity> taskEntityList = taskRepository.findAll();
        return taskEntityList
                .stream()
                .map(taskEntity -> taskMapper.taskEntityToResponseDto(taskEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public TaskResponseDto getTaskById(int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto addTask(TaskRequestDto taskRequestDto) {
        TaskEntity taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);
        taskEntity.setStatusTask(StatusTask.BACKLOG);
        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateTask(TaskRequestDto taskRequestDto, int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskEntity = taskMapper.taskRequestDtoToEntity(taskRequestDto);
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public void deleteTask(int id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskRepository.delete(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updatePerformerTask(int taskId, int performerId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        UserEntity performerEntity = userRepository.findById(performerId).orElseThrow(() -> new NoSuchException("Пользователь не найден"));
        taskEntity.setPerformerId(performerEntity);
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateStatusTask(int taskId, String statusTask) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        StatusTask oldStatusTask = taskEntity.getStatusTask();
        taskEntity.setStatusTask(StatusTask.valueOf(statusTask));
        switch (StatusTask.valueOf(statusTask)) {
            case BACKLOG:
//                taskEntity.setStartTimeTask(null);
//                taskEntity.setEndTimeTask(null);
                break;
            case IN_PROGRESS:
                if (taskEntity.getProjectId().getStatusProject().equals(StatusProject.IN_PROGRESS)) {
                    taskEntity.setStartTimeTask(LocalDateTime.now());
                } else {
                    throw new IncorrectlyEnteredStatusException("Невозможно поменять статус задачи, проект не стартовал.");
                }
                break;
            case DONE:
                if (StatusTask.IN_PROGRESS.equals(taskEntity.getStatusTask())) {
                    taskEntity.setStatusTask(StatusTask.DONE);
                    taskEntity.setEndTimeTask(LocalDateTime.now());
                } else {
                    throw new IncorrectlyEnteredStatusException("Невозможно поменять статус задачи, задача не была на исполнении.");
                }
                break;
        }
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateReleaseTask(int taskId, int releaseId) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        ReleaseEntity releaseEntity = releaseRepository.findById(releaseId).orElseThrow(() -> new NoSuchException("Релиз не найден"));
        taskEntity.setReleaseId(releaseEntity);
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateTimeToCompleteTask(int taskId, Period timeToComplete) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskEntity.setTimeToComplete(timeToComplete);
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public TaskResponseDto updateStartTimeTask(int taskId, LocalDateTime startTimeTask) {
        TaskEntity taskEntity = taskRepository.findById(taskId).orElseThrow(() -> new NoSuchException("Задача не найдена"));
        taskEntity.setStartTimeTask(startTimeTask);
//        taskRepository.save(taskEntity);
        return taskMapper.taskEntityToResponseDto(taskEntity);
    }

    @Transactional
    @Override
    public int showNumberOutstandingTask(int releaseId) {
        return taskRepository.countAllOutstandingTasksByRelease(releaseId);
    }

    @Transactional
    @Override
    public List<TaskResponseDto> showAllOutstandingTasks(int releaseId) {
        List<TaskEntity> taskEntityList = taskRepository.getAllOutstandingTasksByRelease(releaseId);
        return taskEntityList
                .stream()
                .map(taskEntity -> taskMapper.taskEntityToResponseDto(taskEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public LocalDateTime getPlannedEndTimeTask(LocalDateTime startTimeTask, Period timeToComplete) {
        return startTimeTask.plus(timeToComplete);
    }

    @Transactional
    @Override
    public List<TaskResponseDto> getAllTaskSort(TaskFilterRequestDto taskFilterRequestDto) {
        List<TaskEntity> taskEntityList = taskRepository.findAll(TaskSpecification.getByName(taskFilterRequestDto.getName())
                .and(TaskSpecification.GetByRelease(taskFilterRequestDto.getRelease()))
                .and(TaskSpecification.GetByAuthor(taskFilterRequestDto.getAuthor()))
                .and(TaskSpecification.GetByPerformer(taskFilterRequestDto.getPerformer())));
        return taskEntityList
                .stream()
                .map(taskEntity -> taskMapper.taskEntityToResponseDto(taskEntity))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<TaskResponseDto> parsTaskFromCsv(MultipartFile file) throws IOException {
        List<TaskEntity> taskEntityList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(bufferedReader);
        for (CSVRecord record : records) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskId(Integer.parseInt(record.get(0)));
            taskEntity.setName(record.get(1));
            taskEntity.setDescriptionTask(record.get(2));
            taskEntity.setProjectId(projectRepository.findById(Integer.parseInt(record.get(3))).orElseThrow(() -> new NoSuchException("Проект не найден")));
            taskEntity.setStatusTask(StatusTask.valueOf(record.get(4)));
            taskEntity.setAuthorId(userRepository.findById(Integer.parseInt(record.get(5))).orElseThrow(() -> new NoSuchException("Пользователь не найден")));
            taskEntity.setPerformerId(userRepository.findById(Integer.parseInt(record.get(6))).orElseThrow(() -> new NoSuchException("Пользователь не найден")));
            taskEntity.setReleaseId(releaseRepository.findById(Integer.parseInt(record.get(7))).orElseThrow(() -> new NoSuchException("Релиз не найден")));
            taskEntity.setTimeToComplete(Period.parse(record.get(8)));
            taskEntity.setStartTimeTask(LocalDateTime.parse(record.get(9)));
            taskEntity.setEndTimeTask(LocalDateTime.parse(record.get(10)));
            taskEntityList.add(taskEntity);
        }
        return taskEntityList
                .stream()
                .map(taskEntity -> taskMapper.taskEntityToResponseDto(taskEntity))
                .collect(Collectors.toList());
    }
}