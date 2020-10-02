package com.application.Mindart.service;

import com.application.Mindart.entity.Admin;
import com.application.Mindart.entity.Artist;
import com.application.Mindart.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;

    public Admin saveAdmin(Admin admin) {
        return repository.save(admin);
    }
    public List<Admin> getAdmin(){
        return repository.findAll();
    }

    public Admin getAdminById(String id){
        return repository.findById(id).orElse(null);
    }

    public String deleteAdmin(String id){
        repository.deleteById(id);
        return "removed admin with id "+id;


    }
    public Admin updateAdmin(Admin admin){
        return null;
    }
}
