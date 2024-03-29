package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDto saveNewBook(BookDto book);

    void updateBook(Long bookId, BookDto book);

    void deleteBookById(Long bookId);

    void patchBookById(Long bookId, BookDto book);
}
