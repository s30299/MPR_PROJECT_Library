package org.example.library.services;

import lombok.RequiredArgsConstructor;
import org.example.library.mapping.BookMapper;
import org.example.library.models.book.Book;
import org.example.library.models.book.BookRequest;
import org.example.library.models.book.BookResponse;
import org.example.library.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper mapper;

    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(x->mapper.mapToBookResponse(x))
                .toList();
    }
    public List<BookResponse> getBooksByGenre(String genre) {
        return bookRepository.findAllByGenre(genre).stream()
                .map(x->mapper.mapToBookResponse(x))
                .toList();
    }
    public List<BookResponse> getBooksByTitle(String title) {
        return bookRepository.findAllByTitleStartingWith(title).stream()
                .map(x->mapper.mapToBookResponse(x))
                .toList();
    }
    public BookResponse addBook(BookRequest book) {
        Book newBook = mapper.mapToBook(book);
        newBook = bookRepository.save(newBook);
        return mapper.mapToBookResponse(newBook);
    }
    public BookResponse updateBook(UUID id, BookRequest bookOld) {
        Book bookToUpdate = bookRepository.getReferenceById(id);
        bookToUpdate.setAuthors(bookOld.getAuthors());
        bookToUpdate.setTitle(bookOld.getTitle());
        bookToUpdate.setDescription(bookOld.getDescription());
        bookToUpdate.setOriginalLanguage(bookOld.getLanguage());
        bookToUpdate.setPublishedDate(bookOld.getPublishedDate());
        bookToUpdate.setReviews(bookOld.getReviews());
        bookRepository.save(bookToUpdate);
        return mapper.mapToBookResponse(mapper.mapToBook(bookOld));
    }
    public String deleteBook(UUID id) {
        Book book = bookRepository.getReferenceById(id);
        bookRepository.delete(book);
        return "Book:\n"+id+"\ndeleted";
    }
    public List<Book> test(){
        return bookRepository.findAll();
    }
}
