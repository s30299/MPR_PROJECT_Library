package org.example.library.models.book;


import jakarta.persistence.*;
import lombok.*;
import org.example.library.models.author.Author;
import org.example.library.models.review.Review;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
    @NonNull
    private String title;
    private String description;
    @ManyToMany
    private List<Author> authors;
    private int isbn;
    private String genre;
    private String originalLanguage;
    private Date publishedDate;
    @OneToMany
    private List<Review> reviews;




}
