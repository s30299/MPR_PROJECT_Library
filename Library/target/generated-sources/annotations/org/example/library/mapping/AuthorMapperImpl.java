package org.example.library.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.library.models.author.Author;
import org.example.library.models.author.AuthorRequest;
import org.example.library.models.author.AuthorResponse;
import org.example.library.models.book.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T19:52:57+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author mapToAuthor(AuthorRequest authorRequest) {
        if ( authorRequest == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( authorRequest.getFirstName() );
        author.setLastName( authorRequest.getLastName() );
        author.setDateOfBirth( authorRequest.getDateOfBirth() );
        author.setDateOfDeath( authorRequest.getDateOfDeath() );
        author.setAge( authorRequest.getAge() );
        author.setGender( authorRequest.getGender() );
        author.setIntroduction( authorRequest.getIntroduction() );
        List<Book> list = authorRequest.getBooks();
        if ( list != null ) {
            author.setBooks( new ArrayList<Book>( list ) );
        }
        author.setSensitiveData( authorRequest.getSensitiveData() );

        return author;
    }

    @Override
    public AuthorResponse mapToAuthorResponse(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponse authorResponse = new AuthorResponse();

        authorResponse.setFirstName( author.getFirstName() );
        authorResponse.setLastName( author.getLastName() );
        authorResponse.setDateOfBirth( author.getDateOfBirth() );
        authorResponse.setDateOfDeath( author.getDateOfDeath() );
        authorResponse.setAge( author.getAge() );
        authorResponse.setGender( author.getGender() );
        authorResponse.setIntroduction( author.getIntroduction() );
        List<Book> list = author.getBooks();
        if ( list != null ) {
            authorResponse.setBooks( new ArrayList<Book>( list ) );
        }

        return authorResponse;
    }
}
