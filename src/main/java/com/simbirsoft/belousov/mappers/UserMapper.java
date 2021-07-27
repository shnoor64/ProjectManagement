package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserEntity UserRequestDtoToEntity(UserRequestDto userRequestDto);

    UserResponseDto UserEntityToResponseDto(UserEntity userEntity);

}
