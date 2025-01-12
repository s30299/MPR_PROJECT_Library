package org.example.library.models.author;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.example.library.models.book.Book;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Author {
    @Id
    @UuidGenerator
    @NonNull
    private UUID id;
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
    private String sensitiveData;


}
