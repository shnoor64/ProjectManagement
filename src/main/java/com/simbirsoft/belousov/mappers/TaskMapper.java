package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.TaskEntity;
import com.simbirsoft.belousov.rest.dto.TaskRequestDto;
import com.simbirsoft.belousov.rest.dto.TaskResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {

    TaskEntity TaskRequestDtoToEntity(TaskRequestDto taskRequestDto);

    TaskResponseDto TaskEntityToResponseDto(TaskEntity taskEntity);

}
