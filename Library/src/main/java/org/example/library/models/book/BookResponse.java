package org.example.library.models.book;

import jakarta.persistence.*;
import lombok.*;
import org.example.library.models.author.Author;
import org.example.library.models.review.Review;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BookResponse {
    @NonNull
    private String title;
    private String description;
    @NonNull
    @ManyToMany
    private List<Author> authors;
    private String genre;
    private String language;
    private Date publishedDate;
    @OneToMany
    private List<Review> reviews;
}
