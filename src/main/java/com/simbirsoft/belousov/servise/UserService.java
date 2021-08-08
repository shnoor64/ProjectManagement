package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto getUserById(int id);

    UserResponseDto addUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(UserRequestDto userRequestDto, int id);

    void deleteUser(int id);

    UserEntity getUserByName(String name);
}
