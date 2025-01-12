package org.example.library.services;


import lombok.RequiredArgsConstructor;
import org.example.library.mapping.ReviewMapper;
import org.example.library.models.review.Review;
import org.example.library.models.review.ReviewRequest;
import org.example.library.models.review.ReviewResponse;
import org.example.library.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper mapper;

    public List<ReviewResponse> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(x->mapper.mapToReviewRespond(x))
                .toList();
    }
    public List<Review> getAllTest() {
        return reviewRepository.findAll();
    }
    public ReviewResponse addReview(ReviewRequest review) {
        Review newReview = mapper.mapToReview(review);
        reviewRepository.save(newReview);
        return mapper.mapToReviewRespond(newReview);
    }
    public ReviewResponse updateReview(UUID id, ReviewRequest review) {
        Review rev = reviewRepository.getReferenceById(id);
        rev.setAuthor(review.getAuthor());
        rev.setReviewDate(review.getReviewDate());
        rev.setRating(review.getRating());
        rev.setText(review.getText());
        reviewRepository.save(rev);
        return mapper.mapToReviewRespond(rev);
    }
    public String deleteReview(UUID id) {
        Review rev = reviewRepository.getReferenceById(id);
        reviewRepository.delete(rev);
        return "Review deleted";
    }

}
