package com.application.Mindart.controller;

import com.application.Mindart.entity.Company;
import com.application.Mindart.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
