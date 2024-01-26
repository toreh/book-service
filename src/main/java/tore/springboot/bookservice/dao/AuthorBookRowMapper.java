package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.RowMapper;
import tore.springboot.bookservice.model.AuthorBookDto;
import tore.springboot.bookservice.model.BookDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AuthorBookRowMapper implements RowMapper<AuthorBookDto> {
    @Override
    public AuthorBookDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final AuthorBookDto authorBook = new AuthorBookDto();

        authorBook.setAuthorId(rs.getLong("authorId"));
        authorBook.setName(rs.getString("name"));
        authorBook.setBookId(rs.getLong("bookId"));
        authorBook.setTitle(rs.getString("title"));
        authorBook.setSource(rs.getString("source"));

        return authorBook;
    }
}
