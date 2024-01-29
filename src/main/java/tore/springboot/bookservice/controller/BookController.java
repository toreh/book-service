package tore.springboot.bookservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tore.springboot.bookservice.services.BookService;
import tore.springboot.bookservice.model.BookDto;
import tore.springboot.bookservice.services.BookServiceGet;
import tore.springboot.bookservice.services.BookServiceGetByAuthorId;

import java.util.List;

@Slf4j
@RestController
public class BookController {
    public static final String BOOK_PATH = "/api/v1/book";
    public static final String BOOK_PATH_ID = BOOK_PATH + "/{bookId}";
    public static final String AUTHOR_PATH = "/api/v1/author";
    public static final String AUTHOR_PATH_ID = AUTHOR_PATH + "/{authorId}";
    private final BookServiceGet bookServiceGet;
    private final BookServiceGetByAuthorId bookServiceGetByAuthorId;
    private final BookService bookService;
    public BookController(BookServiceGet bookServiceGet, BookServiceGetByAuthorId bookServiceGetByAuthorId, BookService bookService) {
        this.bookServiceGet = bookServiceGet;
        this.bookServiceGetByAuthorId = bookServiceGetByAuthorId;
        this.bookService = bookService;
    }

    @GetMapping(value = BOOK_PATH, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<BookDto> getBookById() {
        return bookServiceGet.getAll();
    }
    @GetMapping(value = BOOK_PATH_ID)
    public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") Long bookId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON));
        return new ResponseEntity(bookServiceGet.getBookById(bookId), headers, HttpStatus.OK);
    }

    @GetMapping(value = AUTHOR_PATH_ID)
    public ResponseEntity<List<BookDto>> getBooksByAuthorId(@PathVariable("authorId") Long authorId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON));
        return new ResponseEntity(bookServiceGetByAuthorId.getBooksByAuthorId(authorId), headers, HttpStatus.OK);
    }


    @PostMapping(BOOK_PATH_ID)
    public ResponseEntity<BookDto> handlePost(@Validated @RequestBody BookDto book) {
        BookDto savedBook = bookService.saveNewBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.APPLICATION_JSON));
        headers.add("Location", "/api/v1/book/" + savedBook.getBookId());
        return new ResponseEntity<>(savedBook, headers, HttpStatus.CREATED);
    }

    @PutMapping (BOOK_PATH_ID)
    public ResponseEntity<Void> updateById(@PathVariable("bookId") Long bookId, @RequestBody BookDto book) {
        bookService.updateBook(bookId, book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(BOOK_PATH_ID)
    public ResponseEntity<Void> deleteById(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(BOOK_PATH_ID)
    public ResponseEntity<Void> updatePatchById(@PathVariable("bookId") Long bookId, @RequestBody BookDto book) {
            bookService.patchBookById(bookId, book);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
