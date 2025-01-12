package org.example.library.repositories;

import org.example.library.models.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    List<Author> findByFirstName(String firstName);
    List<Author> findByLastName(String lastName);
    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
    List<Author> findByAgeBetween(int minAge, int maxAge);
    List<Author> findAllByAge(int age);
}
