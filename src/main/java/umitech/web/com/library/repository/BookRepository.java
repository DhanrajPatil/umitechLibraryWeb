package umitech.web.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umitech.web.com.library.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContains(String title);

    List<Book> findByPublisherContains(String publisherName);

    List<Book> findByWrittenByNameContains(String authorName);

    List<Book> findByWrittenByIdOrderByName(int id);

    List<Book> findByWrittenByNameContainsAndPublisherContainsAndNameContains(String author, String publisher, String title);

    List<Book> findByPublisherContainsAndNameContains(String publisher, String title);

    List<Book> findByWrittenByNameContainsAndNameContains(String author, String title);

    List<Book> findByWrittenByNameContainsAndPublisherContains(String author, String publisher);
}
