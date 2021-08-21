package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoleMapperTest {



    @Test
    void UserRequestDtoMappingEntity() {
        RoleMapper roleMapper= new RoleMapperImpl();
        RoleRequestDto roleRequestDto = new RoleRequestDto(1,"admin");

        RoleEntity roleEntity = roleMapper.roleRequestDtoToEntity(roleRequestDto);

        Assertions.assertEquals(roleRequestDto.getRoleId(), roleEntity.getRoleId());
        Assertions.assertEquals(roleRequestDto.getName(), roleEntity.getName());
    }
}
