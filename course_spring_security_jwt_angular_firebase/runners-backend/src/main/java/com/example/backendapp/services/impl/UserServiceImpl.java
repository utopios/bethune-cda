package com.example.backendapp.services.impl;

import com.example.backendapp.models.Role;
import com.example.backendapp.models.User;
import com.example.backendapp.models.enumerations.ERole;
import com.example.backendapp.models.exceptions.UserNotFoundException;
import com.example.backendapp.repository.RoleRepository;
import com.example.backendapp.repository.UserRepository;
import com.example.backendapp.services.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // This function is to get all username for the users in database
    @Override
    public List<User> findAllUsers() {
       return this.userRepository.findAll();
    }

    @Override
    public void addRoleToUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Set<Role> roles = new HashSet<>();
        Role modRole = roleRepository.findByRoleName(ERole.ROLE_MODERATOR)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        System.out.println(modRole.getRoleName());
        roles.add(modRole);
        user.setRoles(roles);
        user.setModerator(true);
        this.userRepository.save(user);

    }
}
