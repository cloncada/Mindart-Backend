package com.application.mindart.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.mindart.domain.entity.Company;
import com.application.mindart.domain.service.CompanyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company){
        return service.saveCompany(company);
    }

    @GetMapping("/cities")
    public List<Company> findAllCities(){
        return service.getCompanies();
    }

    @GetMapping("/Company/{id}")
    public Company findCompanyById(@PathVariable String id){
        return service.getCompanyById(id);
    }

    @PutMapping("/updateCompany")
    public Company updateCompany(@RequestBody Company company){
        return service.updateCompany(company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public String deleteCompany(@PathVariable  String id){
        return service.deleteCompany(id);
    }

    @PostMapping("/login/company")
    public Company loginUser(@RequestBody Company company) throws Exception {
        String email = company.getEmail();
        String password = company.getPassword();
        Company companyObject = null;

        if(email != null && password != null){
            companyObject = service.searchEmailAndPassword(email,password);
        }
        if (companyObject == null){
            throw new Exception("El usuario o la contraseña estan incorrectos");
        }
        return companyObject;
    }
}
