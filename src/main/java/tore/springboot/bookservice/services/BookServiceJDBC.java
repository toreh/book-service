package tore.springboot.bookservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tore.springboot.bookservice.dao.BookDAO;
import tore.springboot.bookservice.model.AuthorBookDTO;
import tore.springboot.bookservice.model.BookDTO;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class BookServiceJDBC implements BookServiceGet, BookServiceGetByAuthorId{
    BookDAO bookDAO;

    public BookServiceJDBC(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public Optional<BookDTO> getBookById(Long bookId) {

        return Optional.ofNullable(bookDAO.getBookById(bookId));
    }

    @Override
    public List<BookDTO> getAll() {

        return null;
    }

    @Override
    public List<AuthorBookDTO> getBooksByAuthorId(Long authorId) {

        return bookDAO.getBooksByAuthorId(authorId);
    }
}
