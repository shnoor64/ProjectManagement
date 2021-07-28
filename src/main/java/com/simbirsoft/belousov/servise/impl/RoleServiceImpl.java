package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.entity.RoleEntity;
import com.simbirsoft.belousov.mappers.RoleMapperImpl;
import com.simbirsoft.belousov.mappers.RoleMapperImpl;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.rest.dto.*;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.rest.exeption_handing.NoSuchException;
import com.simbirsoft.belousov.servise.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    private RoleMapperImpl roleMapper;

    @Transactional
    @Override
    public List<RoleResponseDto> getAllRoles() {
        List<RoleResponseDto> roleResponseDtoList = new ArrayList<>();
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        return roleEntityList
                .stream()
                .map(roleEntity -> roleMapper.roleEntityToResponseDto(roleEntity))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public RoleResponseDto getRoleById(int id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new NoSuchException("Роль не найдена"));
        return roleMapper.roleEntityToResponseDto(roleEntity);
    }

    @Transactional
    @Override
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto) {
        RoleEntity roleEntity = roleMapper.roleRequestDtoToEntity(roleRequestDto);
        roleRepository.save(roleEntity);
        return roleMapper.roleEntityToResponseDto(roleEntity);
    }

    @Transactional
    @Override
    public RoleResponseDto updateRole(RoleRequestDto roleRequestDto, int id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new NoSuchException("Роль не найдена"));
        roleEntity = roleMapper.roleRequestDtoToEntity(roleRequestDto);
        roleRepository.save(roleEntity);
        return roleMapper.roleEntityToResponseDto(roleEntity);
    }

    @Transactional
    @Override
    public void deleteRole(int id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow(() -> new NoSuchException("Роль не найдена"));
        roleRepository.delete(roleEntity);
    }
}