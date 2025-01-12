package org.example.library.models.review;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.library.models.book.Book;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.UUID;
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Review {
    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
    @NonNull
    private String author;
    @OneToOne
    private Book book;
    @NonNull
    private String text;
    private int rating;
    private Date reviewDate;
}
