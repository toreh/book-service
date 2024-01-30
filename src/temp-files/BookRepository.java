package tore.springboot.bookservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  BookRepository extends JpaRepository<Book, Long>{
}
