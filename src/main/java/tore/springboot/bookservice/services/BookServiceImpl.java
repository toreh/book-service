package tore.springboot.bookservice.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tore.springboot.bookservice.model.BookDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final Map<Long, BookDto> bookMap;
    public BookServiceImpl() {
        this.bookMap = new HashMap<>();

        BookDto book = BookDto.builder()
                .bookId(1L)
                .title("Meningen med livet")
                .isbn("123456")
                .build();

        BookDto book2 = BookDto.builder()
                .bookId(2L)
                .title("Livet er for kjiipt")
                .isbn("123466")
                .build();

        bookMap.put(1L, book);
        bookMap.put(2L, book2);
    }
    @Override
    public Optional<BookDto> getBookById(Long bookId) {
        BookDto book = bookMap.get(bookId);
        return Optional.of(book);
    }

    @Override
    public List<BookDto> getAll() {
        return bookMap.values().stream().toList();
    }

    @Override
    public List<BookDto> getBookByAuthorId(Long authorId) {
        return bookMap.values().stream().toList();
    }

    @Override
    public BookDto saveNewBook(BookDto book) {
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public void updateBook(Long bookId, BookDto book) {
        BookDto existing = bookMap.get(bookId);
        existing.setBookId(bookId);
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookMap.remove(bookId);
    }

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
}
