package org.example.library.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.library.models.author.Author;
import org.example.library.models.author.AuthorRequest;
import org.example.library.models.author.AuthorResponse;
import org.example.library.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class AuthorController {
    @NonNull
    private final AuthorService authorService;

    @GetMapping("/getAllAuthors")
    public List<AuthorResponse> getAuthors() {
        return authorService.getAllAuthors();
    }
    @GetMapping("/findAuthorsByFirstName/{name}")
    public List<AuthorResponse> getAuthorByFirstName(@PathVariable String name) {
        return authorService.findAllByFirstName(name);
    }
    @GetMapping("/findAuthorsByLastName/{name}")
    public List<AuthorResponse> findAuthorsByLastName(@PathVariable String name) {
        return authorService.findAllByLastName(name);
    }
    @GetMapping("/findAuthorsByFirstAndLastName/{Fname}/{Lname}")
    public List<AuthorResponse> findByFirstAndLast(@PathVariable String Fname,@PathVariable String Lname) {
        return authorService.findByFirstNameAndLastName(Fname,Lname);
    }
    @GetMapping("/test/author")// test
    public List<Author> getTest() {
        return authorService.getAllTest();
    }
    @PostMapping("/addAuthor")
    public AuthorResponse addAuthor(@RequestBody AuthorRequest authorRequest) {
        return authorService.addAuthor(authorRequest);
    }
    @PutMapping("/editAuthor/{id}")
    public AuthorResponse updateAuthor(@PathVariable UUID id, @RequestBody AuthorRequest authorRequest) {
        return authorService.updateBook(id,authorRequest);

    }
    @DeleteMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable UUID id) {
        return authorService.deleteBook(id);
    }
}
