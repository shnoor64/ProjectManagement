package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface UserMapper {


    UserEntity userRequestDtoToEntity(UserRequestDto userRequestDto);

    UserResponseDto userEntityToResponseDto(UserEntity userEntity);

//    RoleEntity roleRequestDtoToRoleEntity(RoleRequestDto entity);
//
//    RoleResponseDto roleEntityToRoleResponseDto(RoleEntity entity);

}
