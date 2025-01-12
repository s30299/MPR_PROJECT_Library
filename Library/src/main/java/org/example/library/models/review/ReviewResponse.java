package org.example.library.models.review;

import jakarta.persistence.OneToOne;
import lombok.*;
import org.example.library.models.book.Book;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ReviewResponse {

    @NonNull
    private String author;
    @OneToOne
    private Book book;
    @NonNull
    private String text;
    private int rating;
    private Date reviewDate;
}
