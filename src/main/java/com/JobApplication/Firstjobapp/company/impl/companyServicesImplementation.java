package com.JobApplication.Firstjobapp.company.impl;

import com.JobApplication.Firstjobapp.company.company;
import com.JobApplication.Firstjobapp.company.companyRepository;
import com.JobApplication.Firstjobapp.company.companyServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class companyServicesImplementation implements companyServices {
    private final companyRepository companyRepository;

    public companyServicesImplementation(companyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createJob(company companies) {
        companyRepository.save(companies);
    }

    @Override
    public boolean updateCompany(company companies, Long id) {
        Optional<company> optional =companyRepository.findById(id);
        if(optional.isPresent()){
            company company=optional.get();
            company.setName(companies.getName());
            company.setDescription(companies.getDescription());
            company.setJobs(companies.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
