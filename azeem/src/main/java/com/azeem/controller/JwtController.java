package com.azeem.controller;

import com.azeem.service.JwtService;
import com.azeem.entities.JwtRequest;
import com.azeem.entities.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;


//    Generate new Token
    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    public JwtResponse createToken(@RequestBody JwtRequest jwtRequest){
        return jwtService.generateToken(jwtRequest);
    }


}
