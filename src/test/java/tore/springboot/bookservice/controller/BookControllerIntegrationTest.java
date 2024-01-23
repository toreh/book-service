package tore.springboot.bookservice.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import tore.springboot.bookservice.model.BookDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class BookControllerIntegrationTest {
    @Autowired
    BookController bookController;

    @Test
    void getBookById() throws JSONException {

        System.out.println(bookController.getBookById(1L));

        String expected = "{bookId:1,title:\"Meningen med livet\",isbn:\"123456\"}";
        BookDto resultBook = bookController.getBookById(1L).getBody();
    }

}
