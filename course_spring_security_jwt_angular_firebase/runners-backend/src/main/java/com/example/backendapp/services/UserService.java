package com.example.backendapp.services;


import com.example.backendapp.models.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    void addRoleToUser(Long userId);
}
