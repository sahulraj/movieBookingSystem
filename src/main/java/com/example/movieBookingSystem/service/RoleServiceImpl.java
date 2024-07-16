package com.example.movieBookingSystem.service;

import com.example.movieBookingSystem.entities.Role;
import com.example.movieBookingSystem.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;
    public void addRole(String role)
    {
        Role role1 = new Role();
        role1.setName(role);
        roleRepository.save(role1);
    }
}
