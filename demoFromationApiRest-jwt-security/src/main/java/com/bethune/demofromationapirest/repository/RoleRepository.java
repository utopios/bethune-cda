package com.bethune.demofromationapirest.repository;


import com.bethune.demofromationapirest.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    
    Role findRoleByName(String name);

}
