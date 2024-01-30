package tore.springboot.bookservice.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(value = "localmysql")
class BookServiceJPATest {
    @Autowired
    BookServiceGet bookServiceGet;
    @Autowired
    BookRepository bookRepository;

    @Test
    void getBookById() {
    }

    @Test
    void getAll() {
    }
}