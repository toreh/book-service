package tore.springboot.bookservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tore.springboot.bookservice.model.BookDTO;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookServiceJPA implements BookServiceGet{
    BookRepository bookRepository;
    BookMapper bookMapper;

    public BookServiceJPA(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<BookDTO> getBookById(Long bookId) {

        // FIXME return dao.findById(id).orElse(null);
        return Optional.ofNullable(bookMapper.bookToBookDTO(bookRepository.findById(bookId).get()));
    }

    @Override
    public List<BookDTO> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDTO)
                .toList();
    }
}
