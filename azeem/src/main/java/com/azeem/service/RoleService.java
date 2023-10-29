package com.azeem.service;

import com.azeem.entities.Role;
import com.azeem.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
    public ResponseEntity<Role> saveRole(Role role){
        return ResponseEntity.ok(roleRepo.save(role));
    }
}
