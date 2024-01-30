package tore.springboot.bookservice.mappers;

import org.mapstruct.Mapper;
import tore.springboot.bookservice.model.BookDTO;

@Mapper
public interface BookMapper {
    BookDTO bookToBookDTO(Book book);
    Book bookDTOTobook(BookDTO book);
}
