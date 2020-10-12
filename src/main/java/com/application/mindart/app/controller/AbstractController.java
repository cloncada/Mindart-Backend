package com.application.mindart.app.controller;

import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController {

    public String getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }

    public void validateScope(String scope) {
         SecurityContextHolder.getContext().getAuthentication();
    }

    public String validateUser(String email) throws Exception {
        String principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        if (!principal.equals(email)) {
            throw new Exception("Invalid credentials.");
        }
        return email;
    }

}
