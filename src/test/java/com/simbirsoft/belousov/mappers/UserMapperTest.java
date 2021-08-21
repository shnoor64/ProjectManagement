package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    @Mock
    RoleRepository roleRepository;

    @Test
    void UserRequestDtoMappingEntity() {
        UserMapper userMapper = new UserMapperImpl();
        RoleEntity roleEntity = new RoleEntity(1, "admin");
        UserRequestDto userRequestDto = new UserRequestDto(1, "Oleg", "Olegov", "password",1);
        Mockito.when(roleRepository.findById(1)).thenReturn(Optional.of(roleEntity));
        ReflectionTestUtils.setField(userMapper, "roleRepository", roleRepository);

        UserEntity userEntity = userMapper.userRequestDtoToEntity(userRequestDto);

        Mockito.verify(roleRepository, Mockito.times(1)).findById(1);//тут я проверил вызывался ли 1 раз метод findById, который стучится в репо roleRepository
        Assertions.assertEquals(userRequestDto.getUserId(), userEntity.getUserId());
        Assertions.assertEquals(userRequestDto.getName(), userEntity.getName());
        Assertions.assertEquals(userRequestDto.getSurname(), userEntity.getSurname());
        Assertions.assertEquals(userRequestDto.getPassword(), userEntity.getPassword());


    }
}
