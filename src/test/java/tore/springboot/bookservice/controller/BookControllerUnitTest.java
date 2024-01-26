package tore.springboot.bookservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import tore.springboot.bookservice.model.BookDto;
import tore.springboot.bookservice.services.BookService;
import tore.springboot.bookservice.services.BookServiceImpl;

import java.util.Optional;
import java.util.concurrent.Callable;

import static org.hamcrest.Matchers.is;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerUnitTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BookService bookService;

    BookServiceImpl bookServiceImpl = new BookServiceImpl();

    @Test
    void getBookById() throws Exception {
        BookDto book = bookServiceImpl.getBookById(1L).get();
        given(bookService.getBookById(book.getBookId())).willReturn(Optional.of(book));

        mockMvc.perform(get(BookController.BOOK_PATH + "/" + book.getBookId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.bookId", is(1)))
                .andExpect(jsonPath("$.title", is(book.getTitle())));
    }

    @Test
    void getBookByIdNotFound() throws Exception {
        BookDto book = bookServiceImpl.getBookById(1L).get();
        given(bookService.getBookById(book.getBookId())).willReturn(null);

        mockMvc.perform(get(BookController.BOOK_PATH + "/" + book.getBookId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void getBookByIdThrowsException() throws Exception {
        BookDto book = bookServiceImpl.getBookById(1L).get();
        given(bookService.getBookById(book.getBookId())).willThrow(new RuntimeException("Runtime exception ...."));

        mockMvc.perform(get(BookController.BOOK_PATH + "/" + book.getBookId()))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    void getBookByIdExactMatch() throws Exception {
        BookDto book = bookServiceImpl.getBookById(1L).get();
        given(bookService.getBookById(book.getBookId())).willReturn(Optional.of(book));

        String expected = "{bookId:1,title:\"Meningen med livet\",isbn:\"123456\", source:\"db\"}";
        MvcResult result = mockMvc.perform(get(BookController.BOOK_PATH + "/" + book.getBookId()))
                .andDo(print()).andReturn();
        String resultString = result.getResponse().getContentAsString();
        JSONAssert.assertEquals(resultString, expected, JSONCompareMode.LENIENT);
    }

    @Test
    void getAll() throws Exception {
        given(bookService.getAll()).willReturn(bookServiceImpl.getAll());

        mockMvc.perform(get(BookController.BOOK_PATH))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(2)))
                .andDo(print());
    }

    @Test
    void createNewBook() throws Exception {
        BookDto book = BookDto.builder()
                .bookId(3L)
                .title("Ny bok")
                .isbn("234567")
                .source("db")
                .build();

        given(bookService.saveNewBook(book)).willReturn(book);

        mockMvc.perform(post(BookController.BOOK_PATH + "/" + book.getBookId())
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));

    }

    @Test
    void createNewBookTitleIsNull() throws Exception {
        BookDto book = BookDto.builder()
                .bookId(3L)
                .isbn("234567")
                .build();

        given(bookService.saveNewBook(book)).willReturn(book);

        MvcResult mvcResult = mockMvc.perform(post(BookController.BOOK_PATH + "/" + book.getBookId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isBadRequest()).andReturn();

        System.out.println("===>>>mvcResult: " + mvcResult.getResponse().getContentAsString());
    }

}
