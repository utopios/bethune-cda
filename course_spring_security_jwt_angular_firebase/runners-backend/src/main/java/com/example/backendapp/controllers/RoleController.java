package com.example.backendapp.controllers;

import com.example.backendapp.models.enumerations.ERole;
import com.example.backendapp.services.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<ERole> getAllRoles() {
        return this.roleService.findAllRoles();
    }
}
