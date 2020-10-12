package com.application.mindart.domain.service.authentication;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.application.mindart.domain.entity.Admin;
import com.application.mindart.domain.repository.AdminRepository;

@Primary
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(AdminRepository adminRepository,
                                        @Lazy PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();

        Admin admin = adminRepository.findByEmail(username);
        if (admin == null) {
            throw new UsernameNotFoundException(String.format("User with email: %s not exists.", username));
        }

        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new BadCredentialsException("Invalid credentials.");
        }

        return new UsernamePasswordAuthenticationToken(username,
                password,
                Collections.singleton(new SimpleGrantedAuthority("ADMIN_PRIVILEGE")));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

}
