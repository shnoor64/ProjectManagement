package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoleMapperTest {
    private RoleMapper roleMapper;

    @BeforeEach
    void prepare() {
        roleMapper = new RoleMapperImpl();
    }

    @Test
    void RoleRequestDtoMappingEntity() {
        RoleRequestDto roleRequestDto = new RoleRequestDto(1, "admin");

        RoleEntity roleEntity = roleMapper.roleRequestDtoToEntity(roleRequestDto);

        Assertions.assertEquals(roleRequestDto.getRoleId(), roleEntity.getRoleId());
        Assertions.assertEquals(roleRequestDto.getName(), roleEntity.getName());
    }

    @Test
    void RoleEntityMappingResponseDtoMapping() {
        RoleEntity roleEntity = new RoleEntity(1, "admin");

        RoleResponseDto roleResponseDto = roleMapper.roleEntityToResponseDto(roleEntity);

        Assertions.assertEquals(roleEntity.getRoleId(), roleResponseDto.getRoleId());
        Assertions.assertEquals(roleEntity.getName(), roleResponseDto.getName());

    }
}
