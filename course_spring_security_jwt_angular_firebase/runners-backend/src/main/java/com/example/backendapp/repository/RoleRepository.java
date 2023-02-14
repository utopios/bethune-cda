package com.example.backendapp.repository;

import com.example.backendapp.models.Role;
import com.example.backendapp.models.enumerations.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(ERole role);

    List<Role> findAll();



}
