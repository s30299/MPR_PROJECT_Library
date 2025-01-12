package org.example.library.services;

import lombok.RequiredArgsConstructor;
import org.example.library.mapping.AuthorMapper;
import org.example.library.models.author.Author;
import org.example.library.models.author.AuthorRequest;
import org.example.library.models.author.AuthorResponse;
import org.example.library.repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper mapper;

    public List<AuthorResponse> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public List<AuthorResponse> findAllByFirstName(String name) {
        return authorRepository.findByFirstName(name).stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public List<AuthorResponse> findAllByLastName(String name) {
        return authorRepository.findByLastName(name).stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public List<AuthorResponse> findByFirstNameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName,lastName).stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public List<AuthorResponse> findByAge(int age) {
        return authorRepository.findAllByAge(age).stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public List<Author> getAllTest() {
        return authorRepository.findAll();
    }
    public List<AuthorResponse> findByAgeBetween(int ageL,int ageR) {
        return authorRepository.findByAgeBetween(ageL,ageR).stream()
                .map(x->mapper.mapToAuthorResponse(x))
                .toList();
    }
    public AuthorResponse addAuthor(AuthorRequest author) {
        Author aa = mapper.mapToAuthor(author);
        aa = authorRepository.save(aa);
        return mapper.mapToAuthorResponse(aa);
    }
    public AuthorResponse updateBook(UUID id, AuthorRequest authorOld) {
        Author authorToUpdate = authorRepository.getReferenceById(id);
        authorToUpdate.setFirstName(authorOld.getFirstName());
        authorToUpdate.setLastName(authorOld.getLastName());
        authorToUpdate.setAge(authorOld.getAge());
        authorRepository.save(authorToUpdate);
        return mapper.mapToAuthorResponse(authorToUpdate);
    }
    public String deleteBook(UUID id) {
        Author author = authorRepository.getReferenceById(id);
        authorRepository.delete(author);
        return "Author:\n"+id+"\ndeleted";

    }
}
