package tore.springboot.bookservice.dao;

import tore.springboot.bookservice.model.AuthorBookDTO;
import tore.springboot.bookservice.model.BookDTO;

import java.util.List;

public interface BookDAO {
    public BookDTO getBookById(Long bookId);
    public List<AuthorBookDTO> getBooksByAuthorId(Long authorId);

}

