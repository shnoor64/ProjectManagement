package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.mappers.ProjectMapper;
import com.simbirsoft.belousov.mappers.ProjectMapperImpl;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.rest.dto.ProjectRequestDto;
import com.simbirsoft.belousov.rest.dto.ProjectResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    private ProjectMapperImpl projectMapper;

    @Transactional
    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List <ProjectResponseDto> projectResponseDtoList= new ArrayList<>();
        List <ProjectEntity> projectEntityList = projectRepository.findAll();
        return projectEntityList
                .stream()
                .map(projectEntity -> projectMapper.projectEntityToResponseDto(projectEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public ProjectResponseDto getProjectById(int id) {
        return null;
    }

    @Transactional
    @Override
    public ProjectResponseDto addProject(ProjectRequestDto projectRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public ProjectResponseDto updateProject(ProjectRequestDto projectRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public void deleteProject(int id) {

    }
}
