package tore.springboot.bookservice.services;

import org.springframework.stereotype.Service;
import tore.springboot.bookservice.dao.BookDAO;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceJDBC implements BookServiceGet, BookServiceGetByAuthorId{
    BookDAO bookDAO;

    public BookServiceJDBC(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Optional<BookDto> getBookById(Long bookId) {

        return Optional.ofNullable(bookDAO.getBookById(bookId));
    }

    @Override
    public List<BookDto> getAll() {

        return null;
    }

    @Override
    public List<AuthorBookDto> getBooksByAuthorId(Long authorId) {

        return bookDAO.getBooksByAuthorId(authorId);
    }
}
