package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.BookDto;

import java.util.List;

public interface BookService {
    BookDto getBookById(Long bookId);

    List<BookDto> getAll();

    List<BookDto> getBookByAuthorId(Long authorId);

    BookDto saveNewBook(BookDto book);

    void updateBook(Long bookId, BookDto book);

    void deleteBookById(Long bookId);

    void patchBookById(Long bookId, BookDto book);
}
