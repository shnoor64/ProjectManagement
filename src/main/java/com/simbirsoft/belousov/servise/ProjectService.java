package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {

    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto getProjectById(int id);

    ProjectResponseDto addProject(ProjectRequestDto projectRequestDto);

    ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto, int id);

    void deleteProject(int id);
}

