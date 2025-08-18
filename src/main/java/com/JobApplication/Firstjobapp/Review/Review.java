package com.JobApplication.Firstjobapp.Review;

import com.JobApplication.Firstjobapp.company.company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String review;
    private String rating;

    public Review() {
    }

    @JsonIgnore
    @ManyToOne
    private  company company;

    public company getCompany() {
        return company;
    }

    public void setCompany(company company) {
        this.company = company;
    }


    public Review(Long id, String review) {
        this.id = id;
        this.review = review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
