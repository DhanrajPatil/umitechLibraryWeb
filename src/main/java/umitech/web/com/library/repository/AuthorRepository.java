package umitech.web.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umitech.web.com.library.model.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Author findByEmail(String email);
    List<Author> findByNameContains(String name);
}
