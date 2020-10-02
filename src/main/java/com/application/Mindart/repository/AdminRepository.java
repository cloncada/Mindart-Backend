package com.application.Mindart.repository;

import com.application.Mindart.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByEmailAndPassword(String email, String password);
}
