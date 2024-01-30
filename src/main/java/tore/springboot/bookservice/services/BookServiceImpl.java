package tore.springboot.bookservice.services;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tore.springboot.bookservice.model.AuthorBookDTO;
import tore.springboot.bookservice.model.BookDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
//public class BookServiceImpl implements BookServiceGet, BookServiceGetByAuthorId ,BookService{
    public class BookServiceImpl implements BookService{
    private final Map<Long, BookDTO> bookMap;
    public BookServiceImpl() {
        this.bookMap = new HashMap<>();

        BookDTO book = BookDTO.builder()
                .bookId(1L)
                .title("Meningen med livet")
                .isbn("123456")
                .source("db")
                .build();

        BookDTO book2 = BookDTO.builder()
                .bookId(2L)
                .title("Livet er for kjiipt")
                .isbn("123466")
                .source("db")
                .build();

        bookMap.put(1L, book);
        bookMap.put(2L, book2);
    }
    /*
    @Override
    public Optional<BookDTO> getBookById(Long bookId) {
        BookDTO book = bookMap.get(bookId);
        return Optional.of(book);
    }

   @Override
   public List<BookDTO> getAll() {
       return bookMap.values().stream().toList();
   }

    @Override
    public List<AuthorBookDTO> getBooksByAuthorId(Long authorId) {
        return null;
    }
*/
    @Override
    public BookDTO saveNewBook(BookDTO book) {
        bookMap.put(book.getBookId(), book);
        return book;
    }

    @Override
    public void updateBook(Long bookId, BookDTO book) {
        BookDTO existing = bookMap.get(bookId);
        existing.setBookId(bookId);
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookMap.remove(bookId);
    }

    @Override
    public void patchBookById(Long bookId, BookDTO book) {
        BookDTO existing = bookMap.get(bookId);
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
