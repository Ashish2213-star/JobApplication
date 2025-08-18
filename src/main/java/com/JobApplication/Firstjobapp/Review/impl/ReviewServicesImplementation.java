package com.JobApplication.Firstjobapp.Review.impl;

import com.JobApplication.Firstjobapp.Review.Review;
import com.JobApplication.Firstjobapp.Review.ReviewRepository;
import com.JobApplication.Firstjobapp.Review.ReviewServices;
import com.JobApplication.Firstjobapp.company.company;
import com.JobApplication.Firstjobapp.company.companyServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServicesImplementation implements ReviewServices {
     private final ReviewRepository reviewRepository;
    private final companyServices companyServices;


    public ReviewServicesImplementation(ReviewRepository reviewRepository, companyServices companyServices) {
        this.reviewRepository = reviewRepository;
        this.companyServices=companyServices;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review>reviews=reviewRepository.findByCompanyId(companyId);
        if(reviews.isEmpty())return null;
        return reviews;
    }

    @Override
    public boolean addReview(Review review, Long companyId) {
        company company=companyServices.findById(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;

    }

    @Override
    public Review getReviewById(Long reviewId,Long companyId) {
        return reviewRepository.findByIdAndCompanyId(reviewId, companyId).orElse(null);
    }

    @Override
    public boolean updateReviewById(Long reviewId, Long companyId,Review updateReview) {
        Review review=reviewRepository.findByIdAndCompanyId(reviewId, companyId).orElse(null);
        if(review!=null){
            review.setReview(updateReview.getReview());
            review.setRating(updateReview.getRating());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId, Long companyId) {
        Review review=reviewRepository.findByIdAndCompanyId(reviewId, companyId).orElse(null);
        if(review!=null){
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
