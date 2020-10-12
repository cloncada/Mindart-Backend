package com.application.mindart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.mindart.domain.entity.Project;
import com.application.mindart.domain.service.ProjectService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;


    @GetMapping("/Project/{artistId}")
    public List<Project> findAllProjectsByArtistId(@PathVariable String artistId ){


        return projectService.findByArtistId(artistId);
    }
    @PostMapping("/Project/AddProject")
    public Project addProject(@RequestBody Project project){


        return projectService.addProject(project);
    }




}
