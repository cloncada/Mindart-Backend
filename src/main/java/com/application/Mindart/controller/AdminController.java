package com.application.Mindart.controller;

import com.application.Mindart.entity.Admin;
import com.application.Mindart.entity.Artist;
import com.application.Mindart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    @Autowired
    private AdminService service;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return service.saveAdmin(admin);
    }

    @GetMapping("/Admin")
    public List<Admin> findAllAdmin(){
        return service.getAdmin();
    }

    @GetMapping("/Admin/{id}")
    public Admin findAdminById(@PathVariable String id){
        return service.getAdminById(id);
    }

    @PutMapping("/update/Admin")
    public Admin updateAdmin(@RequestBody Admin admin){
        return service.updateAdmin(admin);
    }

    @DeleteMapping("/delete/Admin/{id}")
    public String deleteAdmin(@PathVariable  String id){
        return service.deleteAdmin(id);
    }

    @PostMapping("/login/admin")
    public Admin loginUser(@RequestBody Admin admin) throws Exception {
        String email = admin.getEmail();
        String password = admin.getPassword();
        Admin adminObject = null;

        if(email != null && password != null){
            adminObject = service.searchEmailAndPassword(email,password);
        }
        if (adminObject == null){
            throw new Exception("El usuario o la contraseña estan incorrectos");
        }
        return adminObject;
    }
}
