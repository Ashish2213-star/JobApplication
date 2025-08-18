package com.JobApplication.Firstjobapp.job.impl;

import com.JobApplication.Firstjobapp.job.Job;
import com.JobApplication.Firstjobapp.job.jobRepository;
import com.JobApplication.Firstjobapp.job.jobServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServicesImplementation implements jobServices {

    jobRepository jobRepository;

    public jobServicesImplementation(jobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob( Job job) {
//        job.setId(Id++);
        jobRepository.save(job);
    }

    @Override
    public Job getByID(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job>jobOptional=jobRepository.findById(id);
            if(jobOptional.isPresent()){
                Job jobs=jobOptional.get();
                jobs.setTittle(updateJob.getTittle());
                jobs.setDescription(updateJob.getDescription());
                jobs.setMinSalary(updateJob.getMinSalary());
                jobs.setMaxSalary(updateJob.getMaxSalary());
                jobs.setLocation(updateJob.getLocation());
                jobRepository.save(jobs);
                return true;

            }
        return false;
    }
}
