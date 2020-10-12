package com.application.mindart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.mindart.domain.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmailAndPassword(String email, String password);

    Admin findByEmail(String email);

}
