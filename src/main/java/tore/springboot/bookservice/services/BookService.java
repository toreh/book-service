package tore.springboot.bookservice.services;

import tore.springboot.bookservice.web.model.BookDto;

import java.util.List;

public interface BookService {
    BookDto getBookById(Long bookId);
    List<BookDto> getBookByAuthorId(Long authorId);
}
