package com.JobApplication.Firstjobapp.Review;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ReviewServices {
    List<Review>getAllReviews(Long companyId);
    boolean addReview(Review review,Long companyId);
    Review  getReviewById(Long reviewId,Long companyId);
    boolean updateReviewById( Long reviewId,Long companyId, Review review);
    boolean deleteReviewById(Long reviewId,Long companyId);
}
