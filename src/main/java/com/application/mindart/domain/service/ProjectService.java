package com.application.mindart.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.mindart.domain.entity.Project;
import com.application.mindart.domain.repository.ProjectRepository;
@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    private Project project;

    public Project addProject(Project project){


        return projectRepository.save(project);
    }
    public  String deleteProjectById(String id){
        projectRepository.deleteById(id);
        return "se removio el proyecto con id "+ id;

    }
    public Project findById(String id){



        return projectRepository.findById(id).orElse(null);

    }
    public List<Project> findByArtistId(String id){

        return projectRepository.findByArtistId(id);


    }



}
