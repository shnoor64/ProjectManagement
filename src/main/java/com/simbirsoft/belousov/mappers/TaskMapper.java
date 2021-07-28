package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TaskMapper {

    TaskEntity taskRequestDtoToEntity(TaskRequestDto taskRequestDto);

    TaskResponseDto taskEntityToResponseDto(TaskEntity taskEntity);

}
