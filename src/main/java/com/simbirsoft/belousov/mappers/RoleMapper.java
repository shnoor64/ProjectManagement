package com.simbirsoft.belousov.mappers;


import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface RoleMapper {

    RoleEntity RoleRequestDtoToEntity(RoleRequestDto roleRequestDto);

    RoleResponseDto RoleEntityToResponseDto(RoleEntity roleEntity);

}
