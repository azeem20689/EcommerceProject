package com.azeem.service;

import com.azeem.dto.UserDto;
import com.azeem.entities.Role;
import com.azeem.entities.User;
import com.azeem.repo.RoleRepo;
import com.azeem.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<User> saveUser(UserDto userDto) {
        Set<Role> roles = new HashSet<>();
        for (String r : userDto.getRole()) {
            Role role = roleRepo.getByRole(r);
            if (role != null) {
                roles.add(role);
            }
        }
        User user = User.builder().username(userDto.getUsername())
                .password(encoder.encode(userDto.getPassword()))
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .role(roles)
                .build();
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }
}
