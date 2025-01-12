package org.example.library.models.author;

import jakarta.persistence.ManyToMany;
import lombok.*;
import org.example.library.models.book.Book;
import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AuthorResponse {
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private int age;
    private String gender;
    private String introduction;
    @ManyToMany
    private List<Book> books;
}
