package tore.springboot.bookservice.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tore.springboot.bookservice.model.AuthorBookDTO;
import tore.springboot.bookservice.model.BookDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "localmysql")
class BookDAOImplTest {

    @Autowired
    BookDAOImpl bookDAO;

    @Test
    void getBookById() {
        BookDTO book = bookDAO.getBookById(1L);

        assertNotNull(book);
        assertNotNull(book.getIsbn());
        assertNotNull(book.getTitle());
        assertNotNull(book.getBookId());
        assertNotNull(book.getSource());

        assertEquals(1L, book.getBookId());
        assertEquals("db", book.getSource());
    }

    @Test
    void getBooksByAuthorId() {
        Long authorId = 1L;
        List<AuthorBookDTO> authorBooks = bookDAO.getBooksByAuthorId(authorId);

        assertNotNull(authorBooks);
        assertEquals(3, authorBooks.size());
        assertEquals(authorId, authorBooks.get(0).getAuthorId());
    }
}