package tore.springboot.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tore.springboot.bookservice.entities.Book;

public interface  BookRepository extends JpaRepository<Book, Long>{
}
