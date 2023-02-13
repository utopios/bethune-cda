package com.bethune.demofromationapirest.service.imp;


import com.bethune.demofromationapirest.model.Role;
import com.bethune.demofromationapirest.repository.RoleRepository;
import com.bethune.demofromationapirest.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        Role role = roleRepository.findRoleByName(name);
        return role;
    }
}
