package org.example.library.mapping;

import javax.annotation.processing.Generated;
import org.example.library.models.review.Review;
import org.example.library.models.review.ReviewRequest;
import org.example.library.models.review.ReviewResponse;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T19:52:57+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review mapToReview(ReviewRequest reviewRequest) {
        if ( reviewRequest == null ) {
            return null;
        }

        Review review = new Review();

        review.setAuthor( reviewRequest.getAuthor() );
        review.setBook( reviewRequest.getBook() );
        review.setText( reviewRequest.getText() );
        review.setRating( reviewRequest.getRating() );
        review.setReviewDate( reviewRequest.getReviewDate() );

        return review;
    }

    @Override
    public ReviewResponse mapToReviewRespond(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewResponse reviewResponse = new ReviewResponse();

        reviewResponse.setAuthor( review.getAuthor() );
        reviewResponse.setBook( review.getBook() );
        reviewResponse.setText( review.getText() );
        reviewResponse.setRating( review.getRating() );
        reviewResponse.setReviewDate( review.getReviewDate() );

        return reviewResponse;
    }
}
