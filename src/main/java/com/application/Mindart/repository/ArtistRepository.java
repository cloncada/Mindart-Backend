package com.application.Mindart.repository;

import com.application.Mindart.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    Artist findByEmailAndPassword(String email, String password);
    Artist findByEmail(String email);
}
