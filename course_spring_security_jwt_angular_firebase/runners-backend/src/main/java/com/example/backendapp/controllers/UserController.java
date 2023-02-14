package com.example.backendapp.controllers;

import com.example.backendapp.models.User;
import com.example.backendapp.payload.response.MessageResponse;
import com.example.backendapp.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> listes = this.userService.findAllUsers();
        return listes;

    } // this is to get and show all users

    @PutMapping("/add-role-to-user/{userId}") // this is put request to add role to user
    public ResponseEntity<?> addRoleToUser(@PathVariable Long userId) {
        this.userService.addRoleToUser(userId);
        return ResponseEntity.ok(new MessageResponse("ROLE_MODERATOR successfully added to user!"));
    }
}
