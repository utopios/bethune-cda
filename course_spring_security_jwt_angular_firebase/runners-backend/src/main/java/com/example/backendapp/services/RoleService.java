package com.example.backendapp.services;

import com.example.backendapp.models.enumerations.ERole;

import java.util.List;

public interface RoleService {

    List<ERole> findAllRoles();

}
