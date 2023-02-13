package com.bethune.demofromationapirest.service;


import com.bethune.demofromationapirest.model.Role;

public interface RoleService {
    Role findByName(String name);
}
