package com.JobApplication.Firstjobapp.job;

import java.util.List;

public interface jobServices {
    List<Job>findAll();
    void  createJob(Job job);
    Job getByID(Long id);
    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job job);
}
