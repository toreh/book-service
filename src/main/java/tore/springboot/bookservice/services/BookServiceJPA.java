package tore.springboot.bookservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tore.springboot.bookservice.dao.BookDAO;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class BookServiceJPA implements BookServiceGet{
    BookServiceGet bookServiceGet;

    public BookServiceJPA(BookServiceGet bookServiceGet) {
        this.bookServiceGet = bookServiceGet;
    }

    @Override
    public Optional<BookDto> getBookById(Long bookId) {

        return bookServiceGet.getBookById(bookId);
    }

    @Override
    public List<BookDto> getAll() {

        return bookServiceGet.getAll();
    }
}
