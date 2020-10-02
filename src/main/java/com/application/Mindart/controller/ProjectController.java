package com.application.Mindart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.application.Mindart.entity.Project;
import com.application.Mindart.service.ProjectService;
import java.util.List;
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
