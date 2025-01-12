package org.example.library.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.library.models.book.Book;
import org.example.library.models.book.BookRequest;
import org.example.library.models.book.BookResponse;
import org.example.library.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BookController {

    @NonNull
    private final BookService bookService;

    @GetMapping("/getAllBooks")
    public List<BookResponse> getBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/getAllBooks/{genre}")
    public List<BookResponse> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }
    @GetMapping("/getAllBooks/{title}")
    public List<BookResponse> getBooksByTitle(@PathVariable String title) {
        return bookService.getBooksByTitle(title);
    }
    @GetMapping("/test/Book") // test
    public List<Book> getTest() {
        return bookService.test();
    }
    @PostMapping("/addBook")
    public BookResponse addBook(@RequestBody BookRequest bookRequest) {
        return bookService.addBook(bookRequest);
    }
    @PutMapping("/editBook/{id}")
    public BookResponse updateBook(@PathVariable UUID id, @RequestBody BookRequest bookRequest) {
        return bookService.updateBook(id, bookRequest);
    }
    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable UUID id) {
        return bookService.deleteBook(id);
    }



}
