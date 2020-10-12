package com.application.mindart.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.mindart.app.api.AdminApi;
import com.application.mindart.app.request.CreateAdminRequest;
import com.application.mindart.domain.entity.Admin;
import com.application.mindart.domain.service.AdminService;

@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/admins")
public class AdminController extends AbstractController {

    @Autowired
    private AdminService service;

    @PostMapping("/")
    public Admin create(@Valid @RequestBody CreateAdminRequest request) throws Exception {
        return service.saveAdmin(request);
    }

    @GetMapping("/all")
    public List<Admin> findAllAdmin() {
        String user = getUser();
        return service.getAdmin();
    }

    @GetMapping("/findByEmail")
    public AdminApi getByEmail(@RequestParam(name = "email") String email) throws Exception {
        return service.getByEmail(email);
    }

    @GetMapping("/{id}")
    public Admin findById(@PathVariable Integer id) throws Exception {
        return service.getAdminById(id, getUser());
    }

    @PutMapping("/")
    public Admin update(@RequestBody Admin admin) {
        return service.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        return service.deleteAdmin(id);
    }

}
