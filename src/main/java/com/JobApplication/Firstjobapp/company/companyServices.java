package com.JobApplication.Firstjobapp.company;



import java.util.List;

public interface companyServices {
    List<company> findAll();
    company findById(Long id);
    void createJob(company companies);
    boolean updateCompany(company companies, Long id);
    boolean deleteById(Long id);

}
