package com.simbirsoft.belousov.servise.impl;

import com.simbirsoft.belousov.repository.RoleRepository;
import com.simbirsoft.belousov.rest.dto.RoleRequestDto;
import com.simbirsoft.belousov.rest.dto.RoleResponseDto;
import com.simbirsoft.belousov.servise.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return null;
    }

    @Override
    public RoleResponseDto getRoleById(int id) {
        return null;
    }

    @Override
    public RoleResponseDto addRole(RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public RoleResponseDto updateRole(RoleRequestDto roleRequestDto) {
        return null;
    }

    @Override
    public void deleteRole(int id) {

    }
}
