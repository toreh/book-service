package tore.springboot.bookservice.dao;

import org.springframework.jdbc.core.RowMapper;
import tore.springboot.bookservice.model.BookDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<BookDTO> {
    @Override
    public BookDTO mapRow(final ResultSet rs, final int rowNum) throws SQLException, SQLException {
        final BookDTO book = new BookDTO();

        book.setBookId(rs.getLong("bookId"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        book.setSource(rs.getString("source"));

        return book;
    }
}
