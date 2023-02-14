package com.example.backendapp.services.impl;

import com.example.backendapp.models.Role;
import com.example.backendapp.models.enumerations.ERole;
import com.example.backendapp.repository.RoleRepository;
import com.example.backendapp.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<ERole> findAllRoles() {
        List<Role> roles = this.roleRepository.findAll();
        List<ERole> roleNames = new ArrayList<>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        return roleNames;
    }
}
