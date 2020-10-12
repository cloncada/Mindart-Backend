package com.application.mindart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.mindart.domain.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {
    Company findByEmailAndPassword(String email, String password);

    Company findByEmail(String email);


}
