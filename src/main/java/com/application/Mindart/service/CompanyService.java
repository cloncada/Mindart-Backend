package com.application.Mindart.service;

import com.application.Mindart.entity.Company;
import com.application.Mindart.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;

    public Company saveCompany(Company company) {
       return repository.save(company);
    }
    public List<Company> getCompanies(){

        return repository.findAll();

    }
    public Company getCompanyById(String id){

        return repository.findById(id).orElse(null);

    }
    public String deleteCompany(String id){
        repository.deleteById(id);
        return "removed "+id;


    }
    public Company updateCompany(Company company){



       return repository.save(company);


    }
}
