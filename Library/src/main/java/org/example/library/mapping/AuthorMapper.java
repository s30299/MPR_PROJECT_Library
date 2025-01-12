package org.example.library.mapping;

import org.example.library.models.author.Author;
import org.example.library.models.author.AuthorRequest;
import org.example.library.models.author.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    @Mapping(target = "id", ignore = true)
    Author mapToAuthor(AuthorRequest authorRequest);
    AuthorResponse mapToAuthorResponse(Author author);
}
