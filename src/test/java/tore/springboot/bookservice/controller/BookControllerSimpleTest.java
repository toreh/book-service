package tore.springboot.bookservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookControllerSimpleTest {
    @Autowired
    BookController bookController;

    @Test
    void getBookById(){
        System.out.println(bookController.getBookById(1L));
    }

}
