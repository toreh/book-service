package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.BookDTO;

public interface BookService {
    BookDTO saveNewBook(BookDTO book);

    void updateBook(Long bookId, BookDTO book);

    void deleteBookById(Long bookId);

    void patchBookById(Long bookId, BookDTO book);
}
