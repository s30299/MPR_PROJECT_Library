package org.example.library.repositories;

import org.example.library.models.book.Book;
import org.example.library.models.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByRating(int rating);
    List<Review> findByAuthor(String author);
    List<Review> findByBook(Book book);
    List<Review> findAllByTextContains(String text);
}
