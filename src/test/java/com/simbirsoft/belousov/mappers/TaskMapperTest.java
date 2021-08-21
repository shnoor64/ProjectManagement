package com.simbirsoft.belousov.mappers;

import com.simbirsoft.belousov.entity.ProjectEntity;
import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.enums.StatusPay;
import com.simbirsoft.belousov.enums.StatusProject;
import com.simbirsoft.belousov.repository.ProjectRepository;
import com.simbirsoft.belousov.repository.ReleaseRepository;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.repository.UserRepository;
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
class TaskMapperTest {

    @Mock
    ProjectRepository projectRepository;
    @Mock
    UserRepository userRepository;
    @Mock
    ReleaseRepository releaseRepository;

    @Test
    void TaskRequestDtoMappingEntity() {
        TaskMapper taskMapper= new TaskMapperImpl();
        RoleEntity roleEntity = new RoleEntity(1, "admin");
        UserEntity userEntity = new UserEntity(1, "Oleg", "Olegov", "password",roleEntity);
        ProjectEntity projectEntity = new ProjectEntity(1, "Velodrom", "For velodrom", "OOO Velodrom", StatusProject.BACKLOG, StatusPay.PAID);
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
