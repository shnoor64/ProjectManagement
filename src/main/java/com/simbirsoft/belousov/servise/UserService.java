package com.simbirsoft.belousov.servise;

import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    /**
     * Метод позволяет получить всех пользователей
     *
     * @return List<UserResponseDto> - лист пользователей
     */
    List<UserResponseDto> getAllUsers();

    /**
     * Метод позволяет получить пользователя по id
     *
     * @param id - id релиза
     * @return UserResponseDto - искомый пользователь
     */
    UserResponseDto getUserById(int id);

    /**
     * Метод позволяет добавить пользователя
     *
     * @param userRequestDto - добавляемый пользователь,
     * @return UserResponseDto -добавленный пользователь
     */
    UserResponseDto addUser(UserRequestDto userRequestDto);

    /**
     * Метод позволяет обновить пользователя
     *
     * @param userRequestDto - пользователь для обновления,
     * @param id- id релиза
     * @return UserResponseDto -обновленный пользователь
     */
    UserResponseDto updateUser(UserRequestDto userRequestDto, int id);

    /**
     * Метод позволяет удалить пользователя
     *
     * @param id- id пользователя
     */
    void deleteUser(int id);

}
