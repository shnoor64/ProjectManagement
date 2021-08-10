package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.mappers.ProjectMapperImpl;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.TaskRepository;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.IncorrectlyEnteredStatusException;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ProjectMapperImpl projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, TaskRepository taskRepository, ProjectMapperImpl projectMapper) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.projectMapper = projectMapper;
    }

    @Transactional
    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<ProjectResponseDto> projectResponseDtoList = new ArrayList<>();
        List<ProjectEntity> projectEntityList = projectRepository.findAll();
        return projectEntityList
                .stream()
                .map(projectEntity -> projectMapper.projectEntityToResponseDto(projectEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public ProjectResponseDto getProjectById(int id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        return projectMapper.projectEntityToResponseDto(projectEntity);

    }

    @Transactional
    @Override
    public ProjectResponseDto addProject(ProjectRequestDto projectRequestDto) {
        ProjectEntity projectEntity = projectMapper.projectRequestDtoToEntity(projectRequestDto);
        projectEntity.setStatusProject(StatusProject.BACKLOG);
        projectRepository.save(projectEntity);
        return projectMapper.projectEntityToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, int id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        projectRepository.save(projectMapper.projectRequestDtoToEntity(projectRequestDto));
        return projectMapper.projectEntityToResponseDto(projectEntity);
    }

    @Transactional
    @Override
    public void deleteProject(int id) {
        ProjectEntity projectEntity = projectRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        projectRepository.delete(projectEntity);
    }

    @Override
    public ProjectResponseDto updateStatusProject(int projectId, String statusProject) {
        ProjectEntity projectEntity = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchException("Проект не найден"));
        if (statusProject.equals(StatusProject.CLOSED)) {
            if (taskRepository.countAllNotDoneTasksByProject(projectId) != 0) {
                throw new IncorrectlyEnteredStatusException("Невозможно поменять статус проекта,не все задачи завершены");
            }
        }
        projectEntity.setStatusProject(StatusProject.valueOf(statusProject));
        projectRepository.save(projectEntity);
        return projectMapper.projectEntityToResponseDto(projectEntity);

    }
}
