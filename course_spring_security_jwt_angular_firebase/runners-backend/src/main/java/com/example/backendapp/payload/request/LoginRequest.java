package com.example.backendapp.payload.request;

import javax.validation.constraints.NotBlank;

//  with http login this attirbutes are what is send in the http post for login
public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
