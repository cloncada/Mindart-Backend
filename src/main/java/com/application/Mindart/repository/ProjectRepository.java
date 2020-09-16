package com.application.Mindart.repository;

import com.application.Mindart.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {

List<Project> findByName( String Name);

}
