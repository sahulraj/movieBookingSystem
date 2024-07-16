package com.example.movieBookingSystem.controllers;

import com.example.movieBookingSystem.entities.Role;
import com.example.movieBookingSystem.entities.RoleModel;
import com.example.movieBookingSystem.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @PostMapping("/role")
    public ResponseEntity<HttpStatus> addRole(@RequestBody RoleModel role)
    {
        Role role1 = new Role();
        role1.setName(role.getName());
        roleRepository.save(role1);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}