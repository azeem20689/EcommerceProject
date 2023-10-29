package com.azeem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("/testing")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public String Testing(){
        return "This is User testing ";
    }

    @GetMapping("/testing2")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String Testing2(){
        return "This is ADMIN testing ";
    }



}
