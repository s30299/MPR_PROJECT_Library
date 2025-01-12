package org.example.library.models.review;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ReviewRequest {
    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
    @NonNull
    private String author;
    @OneToOne
    private org.example.library.models.book.Book Book;
    @NonNull
    private String text;
    private int rating;
    private Date reviewDate;
}
