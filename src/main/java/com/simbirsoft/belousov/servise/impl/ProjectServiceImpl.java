package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.servise.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        return null;
    }

    @Override
    public ProjectResponseDto getProjectById(int id) {
        return null;
    }

    @Override
    public ProjectResponseDto addProject(ProjectRequestDto projectRequestDto) {
        return null;
    }

    @Override
    public ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto) {
        return null;
    }

    @Override
    public void deleteProject(int id) {

    }
}
