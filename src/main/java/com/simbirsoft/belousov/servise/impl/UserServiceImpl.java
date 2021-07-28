package com.simbirsoft.belousov.servise.impl;


import com.simbirsoft.belousov.entity.UserEntity;
import com.simbirsoft.belousov.mappers.UserMapperImpl;
import com.simbirsoft.belousov.repository.UserRepository;

import com.simbirsoft.belousov.rest.dto.UserRequestDto;
import com.simbirsoft.belousov.rest.dto.UserResponseDto;

import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapperImpl userMapper;

    @Transactional
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList
                .stream()
                .map(userEntity -> userMapper.userEntityToResponseDto(userEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public UserResponseDto getUserById(int id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        return userMapper.userEntityToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.userRequestDtoToEntity(userRequestDto);
        userRepository.save(userEntity);
        return userMapper.userEntityToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto, int id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        userEntity = userMapper.userRequestDtoToEntity(userRequestDto);
        userRepository.save(userEntity);
        return userMapper.userEntityToResponseDto(userEntity);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new NoSuchException("Проект не найден"));
        userRepository.delete(userEntity);
    }
}
