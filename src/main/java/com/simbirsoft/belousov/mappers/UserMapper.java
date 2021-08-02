package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public abstract class UserMapper {

    @Autowired
    protected RoleRepository roleRepository;

    @Mappings({
    @Mapping(target = "role", expression = "java(roleRepository.findById(userRequestDto.getRoleId()).orElseThrow(() -> new NoSuchException(\"Роль не найдена\")))")
    })
    public abstract UserEntity userRequestDtoToEntity(UserRequestDto userRequestDto) throws NoSuchException;
    @Mappings({
    @Mapping(target = "roleId", expression = "java(userEntity.getRole().getRoleId())")
    })
    public abstract UserResponseDto userEntityToResponseDto(UserEntity userEntity);


}
