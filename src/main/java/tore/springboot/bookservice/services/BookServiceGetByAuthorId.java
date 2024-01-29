package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;

public interface BookServiceGetByAuthorId {
    List<AuthorBookDto> getBooksByAuthorId(Long authorId);
}
