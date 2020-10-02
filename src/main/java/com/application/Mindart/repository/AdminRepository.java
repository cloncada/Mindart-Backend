package com.application.Mindart.repository;

import com.application.Mindart.entity.Admin;
import com.application.Mindart.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
