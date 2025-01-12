package org.example.library.mapping;


import org.example.library.models.book.Book;
import org.example.library.models.book.BookRequest;
import org.example.library.models.book.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target="originalLanguage", source="language")
    Book mapToBook(BookRequest book);
    @Mapping(target ="language",source = "originalLanguage")
    BookResponse mapToBookResponse(Book book);
}
