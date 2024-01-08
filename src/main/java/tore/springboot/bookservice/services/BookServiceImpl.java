package tore.springboot.bookservice.services;

import org.springframework.stereotype.Service;
import tore.springboot.bookservice.web.model.BookDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Override
    public BookDto getBookById(Long bookId) {
        return BookDto.builder()
                .bookId(1L)
                .title("Meningen med livet")
                .isbn("123456")
                .build();
    }
    @Override
    public List<BookDto> getBookByAuthorId(Long authorId) {
        List<BookDto> bookList = new ArrayList<>();
        bookList.add(BookDto.builder()
                .bookId(1L)
                .title("Meningen med livet")
                .build());
        bookList.add(BookDto.builder()
                .bookId(2L)
                .title("Livet er for kjiipt")
                .build());
        return bookList;
    }


}
