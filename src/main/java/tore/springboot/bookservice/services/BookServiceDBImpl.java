package tore.springboot.bookservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tore.springboot.bookservice.dao.BookDAO;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;
import java.util.Optional;

//@Primary
@Service
public class BookServiceDBImpl implements BookService{
    BookDAO bookDAO;

    public BookServiceDBImpl(BookDAO bookDAO) {
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

    @Override
    public BookDto saveNewBook(BookDto book) {
        return null;
    }

    @Override
    public void updateBook(Long bookId, BookDto book) {
    }

    @Override
    public void deleteBookById(Long bookId){
    }

    @Override
    public void patchBookById(Long bookId, BookDto book) {

    }
/*
    @Override
    public void patchBookById(Long bookId, BookDto book) {
        BookDto existing = bookMap.get(bookId);
        if (book.getBookId() != null){
            existing.setBookId(book.getBookId());
        }
        if (StringUtils.hasText(book.getTitle())){
            existing.setTitle(book.getTitle());
        }
        if (StringUtils.hasText(book.getIsbn())){
            existing.setTitle(book.getIsbn());
        }

    }
     */
}
