package com.application.mindart.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.mindart.domain.entity.Credential;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, String> {

    Optional<Credential> findByClientId(String clientId);

}
