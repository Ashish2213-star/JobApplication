package com.JobApplication.Firstjobapp.Review;

import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
   private final ReviewServices reviewServices;

    public ReviewController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>>getAllReviews(@PathVariable Long companyId){
        List<Review>reviews=reviewServices.getAllReviews(companyId);
        if(reviews==null)return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
    @PostMapping("/reviews")
    public ResponseEntity<String>addReview(@RequestBody Review review , @PathVariable Long companyId){
        boolean isPresentCompany=reviewServices.addReview(review,companyId);
        if(!isPresentCompany) return new ResponseEntity<>("Company is not present ", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Reviews add successfully",HttpStatus.OK);

    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review>getReviewsById(@PathVariable Long reviewId, @PathVariable Long companyId){
        Review review=reviewServices.getReviewById(reviewId,companyId);
        if(review==null)return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String>updateReviewById(@PathVariable Long reviewId, @PathVariable Long companyId , @RequestBody Review review){
        boolean isUpdate=reviewServices.updateReviewById(reviewId,companyId,review );
        if(isUpdate)return new ResponseEntity<>("review was Update successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String>deleteReviewBYId(@PathVariable Long reviewId, @PathVariable Long companyId){
        boolean isDeleted=reviewServices.deleteReviewById(reviewId,companyId);
        if(isDeleted)return new ResponseEntity<>("Review is deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
    }
}
