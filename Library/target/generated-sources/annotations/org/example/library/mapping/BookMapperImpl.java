package org.example.library.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.library.models.author.Author;
import org.example.library.models.book.Book;
import org.example.library.models.book.BookRequest;
import org.example.library.models.book.BookResponse;
import org.example.library.models.review.Review;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-11T19:52:57+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book mapToBook(BookRequest book) {
        if ( book == null ) {
            return null;
        }

        Book book1 = new Book();

        book1.setOriginalLanguage( book.getLanguage() );
        book1.setTitle( book.getTitle() );
        book1.setDescription( book.getDescription() );
        List<Author> list = book.getAuthors();
        if ( list != null ) {
            book1.setAuthors( new ArrayList<Author>( list ) );
        }
        book1.setIsbn( book.getIsbn() );
        book1.setGenre( book.getGenre() );
        book1.setPublishedDate( book.getPublishedDate() );
        List<Review> list1 = book.getReviews();
        if ( list1 != null ) {
            book1.setReviews( new ArrayList<Review>( list1 ) );
        }

        return book1;
    }

    @Override
    public BookResponse mapToBookResponse(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setLanguage( book.getOriginalLanguage() );
        bookResponse.setTitle( book.getTitle() );
        bookResponse.setDescription( book.getDescription() );
        List<Author> list = book.getAuthors();
        if ( list != null ) {
            bookResponse.setAuthors( new ArrayList<Author>( list ) );
        }
        bookResponse.setGenre( book.getGenre() );
        bookResponse.setPublishedDate( book.getPublishedDate() );
        List<Review> list1 = book.getReviews();
        if ( list1 != null ) {
            bookResponse.setReviews( new ArrayList<Review>( list1 ) );
        }

        return bookResponse;
    }
}
