package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import tore.springboot.bookservice.model.AuthorBookDTO;
import tore.springboot.bookservice.model.BookDTO;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    public static final String SQL_SELECT_BY_ID = "select bookId, title, isbn, source from book where bookId = ?";
    public static final String SQL_SELECT_BY_ID_NAMED = "select bookId, title, isbn, source from book where bookId = :id";
    public static final String SQL_SELECT_BY_AUTHOR_ID_NAMED = "select author.authorId, author.name, book.bookId, book.title, book.source from author LEFT JOIN book ON book.authorId = author.authorId where author.authorId = :id";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public BookDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

   //@Override
    public BookDTO getBookById2(Long bookId) {

        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new BookRowMapper(), bookId);
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
        BookDTO book =  namedParameterJdbcTemplate.queryForObject(SQL_SELECT_BY_ID_NAMED, namedParameters ,new BookRowMapper());
        return book;
    }

    @Override
    public List<AuthorBookDTO> getBooksByAuthorId(Long authorId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_AUTHOR_ID_NAMED, namedParameters ,new AuthorBookRowMapper());
    }

}
