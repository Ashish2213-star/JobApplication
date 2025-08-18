package com.JobApplication.Firstjobapp.company;

import com.JobApplication.Firstjobapp.Review.Review;
import com.JobApplication.Firstjobapp.job.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;


    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name cannot be longer than 100 characters")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job>jobs;

    @OneToMany(mappedBy = "company")
    private List<Review> review;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
