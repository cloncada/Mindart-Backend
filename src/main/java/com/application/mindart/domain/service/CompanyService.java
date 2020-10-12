package com.application.mindart.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.mindart.domain.entity.Company;
import com.application.mindart.domain.repository.CompanyRepository;

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

    public Company searchEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }
}
