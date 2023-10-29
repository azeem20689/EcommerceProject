package com.azeem.controller;

import com.azeem.entities.Role;
import com.azeem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    @PostMapping("/createRole")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return roleService.saveRole(role);
    }
}
