package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookServiceGet {
    Optional<BookDto> getBookById(Long bookId);

    List<BookDto> getAll();

}
