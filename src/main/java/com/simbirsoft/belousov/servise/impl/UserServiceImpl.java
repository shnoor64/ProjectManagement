package com.simbirsoft.belousov.servise.impl;


import com.simbirsoft.belousov.repository.UserRepository;
import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;
import com.simbirsoft.belousov.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public List<UserResponseDto> getAllUsers() {
        return null;
    }

    @Transactional
    @Override
    public UserResponseDto getUserById(int id) {
        return null;
    }

    @Transactional
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Transactional
    @Override
    public void deleteUser(int id) {

    }
}
