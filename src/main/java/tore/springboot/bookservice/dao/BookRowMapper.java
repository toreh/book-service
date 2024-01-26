package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.RowMapper;
import tore.springboot.bookservice.model.BookDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookDto> {
    @Override
    public BookDto mapRow(final ResultSet rs, final int rowNum) throws SQLException, SQLException {
        final BookDto book = new BookDto();

        book.setBookId(rs.getLong("bookId"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        book.setSource(rs.getString("source"));

        return book;
    }
}
