package com.application.mindart.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.mindart.domain.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    Artist findByEmailAndPassword(String email, String password);

    Artist findByEmail(String email);

}
