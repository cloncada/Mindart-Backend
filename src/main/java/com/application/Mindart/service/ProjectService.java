package com.application.Mindart.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.application.Mindart.entity.Project;
import com.application.Mindart.repository.ProjectRepository;
import java.util.List;
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
