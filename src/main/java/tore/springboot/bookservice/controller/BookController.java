package tore.springboot.bookservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tore.springboot.bookservice.services.BookService;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookDto> getBookById() {
        return bookService.getAll();
    }
    @GetMapping(value = "{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BookDto book) {
        BookDto savedBook = bookService.saveNewBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/book/" + savedBook.getBookId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping ("{bookId}")
    public ResponseEntity updateById(@PathVariable("bookId") Long bookId, @RequestBody BookDto book) {
        bookService.updateBook(bookId, book);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity deleteById(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{bookId}")
    public ResponseEntity updatePatchById(@PathVariable("bookId") Long bookId, @RequestBody BookDto book) {
            bookService.patchBookById(bookId, book);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

    }
