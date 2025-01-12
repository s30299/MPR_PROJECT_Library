package org.example.library.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.example.library.models.review.Review;
import org.example.library.models.review.ReviewRequest;
import org.example.library.models.review.ReviewResponse;
import org.example.library.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    @NonNull
    private final ReviewService reviewService;

    @GetMapping("/getAllReviews")
    public List<ReviewResponse> allReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/test/review")//test
    public List<Review> getTest() {
        return reviewService.getAllTest();
    }
    @PostMapping("/addReview")
    public ReviewResponse addReview(@RequestBody ReviewRequest rev) {
        return reviewService.addReview(rev);
    }
    @PutMapping("/editReview/{id}")
    public ReviewResponse updateAuthor(@PathVariable UUID id, @RequestBody ReviewRequest rev) {
        return reviewService.updateReview(id, rev);
    }
    @DeleteMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable UUID id) {
        return reviewService.deleteReview(id);
    }
}
