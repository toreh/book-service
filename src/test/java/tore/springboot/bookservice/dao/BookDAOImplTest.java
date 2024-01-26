package tore.springboot.bookservice.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "localmysql")
class BookDAOImplTest {

    @Autowired
    BookDAOImpl bookDAO;

    @Test
    void getBookById() {
        BookDto book = bookDAO.getBookById(1L);

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
        List<AuthorBookDto> authorBooks = bookDAO.getBooksByAuthorId(authorId);

        assertNotNull(authorBooks);
        assertEquals(3, authorBooks.size());
        assertEquals(authorId, authorBooks.get(0).getAuthorId());
    }
}