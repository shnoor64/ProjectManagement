package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {

    /**
     * Метод позволяет получить все проекты
     *
     * @return List<ProjectResponseDto> - лист проектов
     */
    List<ProjectResponseDto> getAllProjects();

    /**
     * Метод позволяет получить проект по id
     *
     * @param id - id проекта
     * @return ProjectResponseDto - искомый проект
     */
    ProjectResponseDto getProjectById(int id);

    /**
     * Метод позволяет добавить проект
     *
     * @param projectRequestDto - добавляемый проект,
     * @return ProjectResponseDto -добавленный проект
     */
    ProjectResponseDto addProject(ProjectRequestDto projectRequestDto);

    /**
     * Метод позволяет обновить проект
     *
     * @param projectRequestDto - опроект для обновления,
     * @param id- id проекта
     * @return ProjectResponseDto -обновленный проект
     */
    ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, int id);

    /**
     * Метод позволяет удалить проект
     *
     * @param id- id проекта
     */
    void deleteProject(int id);

    /**
     * Метод позволяет обновить статус проекта
     *
     * @param statusProject - статус проекта,
     * @param projectId- id проекта
     * @return ProjectResponseDto -обновленный проект
     */
    ProjectResponseDto updateStatusProject(int projectId, String statusProject);

}

