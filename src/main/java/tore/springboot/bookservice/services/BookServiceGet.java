package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookServiceGet {
    Optional<BookDTO> getBookById(Long bookId);

    List<BookDTO> getAll();

}
