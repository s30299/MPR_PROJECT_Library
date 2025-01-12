package org.example.library.repositories;


import org.example.library.models.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findByTitle(String title);
    List<Book> findAllByTitleContaining(String title);
    List<Book> findAllByTitleStartingWith(String title);
    List<Book> findAllByTitleEndingWith(String title);
    List<Book> findAllByGenre(String genre);
}
