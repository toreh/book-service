package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.RowMapper;
import tore.springboot.bookservice.model.AuthorBookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorBookRowMapper implements RowMapper<AuthorBookDTO> {
    @Override
    public AuthorBookDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final AuthorBookDTO authorBook = new AuthorBookDTO();

        authorBook.setAuthorId(rs.getLong("authorId"));
        authorBook.setName(rs.getString("name"));
        authorBook.setBookId(rs.getLong("bookId"));
        authorBook.setTitle(rs.getString("title"));
        authorBook.setSource(rs.getString("source"));

        return authorBook;
    }
}
