package tore.springboot.bookservice.dao;

import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;

public interface BookDAO {
    public BookDto getBookById(Long bookId);
    public List<AuthorBookDto> getBooksByAuthorId(Long authorId);

}

