package org.example.library.mapping;

import org.example.library.models.review.Review;
import org.example.library.models.review.ReviewRequest;
import org.example.library.models.review.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(target = "id", ignore = true)
    Review mapToReview(ReviewRequest reviewRequest);
    ReviewResponse mapToReviewRespond(Review review);
}
