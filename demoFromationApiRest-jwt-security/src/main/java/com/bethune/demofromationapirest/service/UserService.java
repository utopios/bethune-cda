package com.bethune.demofromationapirest.service;







import com.bethune.demofromationapirest.model.User;
import com.bethune.demofromationapirest.model.UserDto;

import java.util.List;

public interface UserService {
    
    User save(UserDto user);

    List<User> findAll();

    User findOne(String username);
}
