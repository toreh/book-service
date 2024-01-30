package tore.springboot.bookservice.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import tore.springboot.bookservice.model.AuthorBookDTO;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "localmysql")
class BookControllerIntegrationTest {
    @LocalServerPort
    private int port;
    HttpHeaders headers = new HttpHeaders();

    @Autowired
    BookController bookController;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void getBookById() throws JSONException {
        long bookId = 1L;

        String expected = "{bookId:1,title:\"Meningen med livet\",isbn:\"123456\"}";

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort(BookController.BOOK_PATH + "/" + bookId),
                HttpMethod.GET, entity, String.class);

        System.out.println("===>>>ResponseEntity: " + response);
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    void getBooksByAuthorId() {
        long authorId = 1L;
        int expectedNumOfBooks = 3;

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<AuthorBookDTO>> response = restTemplate.exchange(
                createURLWithPort(BookController.AUTHOR_PATH + "/" + authorId),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<AuthorBookDTO>>() {});

        System.out.println("===>>>ResponseEntity: " + response);
        List<AuthorBookDTO> authorBooks = response.getBody();

        assertNotNull(response);
        assertEquals(expectedNumOfBooks, authorBooks.size());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
