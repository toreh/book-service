package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

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
    public BookDto getBookById2(Long bookId) {

        return jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, new BookRowMapper(), bookId);
    }

    @Override
    public BookDto getBookById(Long bookId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
        BookDto book =  namedParameterJdbcTemplate.queryForObject(SQL_SELECT_BY_ID_NAMED, namedParameters ,new BookRowMapper());
        return book;
    }

    @Override
    public List<AuthorBookDto> getBooksByAuthorId(Long authorId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", 1);
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_AUTHOR_ID_NAMED, namedParameters ,new AuthorBookRowMapper());
    }

}
