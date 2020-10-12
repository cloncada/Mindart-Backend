package com.application.mindart.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.mindart.domain.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

List<Project> findByName(String name);
List <Project> findByArtistId(String artistId);

}
