package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class TaskMapper {
    @Autowired
    protected ProjectRepository projectRepository;
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ReleaseRepository releaseRepository;

    @Mappings({
            @Mapping(target = "projectId", expression = "java(projectRepository.findById(taskRequestDto.getProjectId()).orElseThrow(() -> new NoSuchException(\"Проект не найден\")))"),
            @Mapping(target = "authorId", expression = "java(userRepository.findById(taskRequestDto.getAuthorId()).orElseThrow(() -> new NoSuchException(\"Автор не найден\")))"),
            @Mapping(target = "performerId", expression = "java(userRepository.findById(taskRequestDto.getPerformerId()).orElseThrow(() -> new NoSuchException(\"Исполнитель не найден\")))"),
            @Mapping(target = "releaseId", expression = "java(releaseRepository.findById(taskRequestDto.getReleaseId()).orElseThrow(() -> new NoSuchException(\"Релиз не найден\")))"),

    })
    public abstract TaskEntity taskRequestDtoToEntity(TaskRequestDto taskRequestDto) throws NoSuchException;

    @Mappings({
            @Mapping(target = "projectId", expression = "java(taskEntity.getProjectId().getProjectId())"),
            @Mapping(target = "authorId", expression = "java(taskEntity.getAuthorId().getUserId())"),
            @Mapping(target = "performerId", expression = "java(taskEntity.getPerformerId().getUserId())"),
            @Mapping(target = "releaseId", expression = "java(taskEntity.getReleaseId().getReleaseId())"),
    })
    public abstract TaskResponseDto taskEntityToResponseDto(TaskEntity taskEntity);

}
