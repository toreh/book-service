package tore.springboot.bookservice.services;

import tore.springboot.bookservice.model.AuthorBookDTO;

import java.util.List;

public interface BookServiceGetByAuthorId {
    List<AuthorBookDTO> getBooksByAuthorId(Long authorId);
}
