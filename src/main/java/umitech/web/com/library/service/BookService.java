package umitech.web.com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umitech.web.com.library.dto.CreateBookRequest;
import umitech.web.com.library.model.Author;
import umitech.web.com.library.model.Book;
import umitech.web.com.library.repository.BookRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorService authorService;

    public Book createBook(CreateBookRequest bookReq) {
        Book bk = bookReq.to();
        Author auth = authorService.createOrGet(bk.getWrittenBy());
        bk.setWrittenBy(auth);
        return bookRepo.save(bk);
    }

    public Book delete(int bookId) {
        Book bk = this.bookRepo.findById(bookId).orElse(null);
        this.bookRepo.deleteById(bookId);
        return bk;
    }

    public List<Book> searchByTitle(String title) {
        return this.bookRepo.findByNameContains(title);
    }

    public List<Book> searchByPublisher(String publisherName) {
        return this.bookRepo.findByPublisherContains(publisherName);
    }

    public Set<Book> getAllBooks() {
        Sort sortBy = Sort.by(Sort.Direction.ASC, "id");
        List<Book> duplicateBooks = this.bookRepo.findAll(sortBy);
        return new HashSet<>(duplicateBooks);
    }

    public Set<String> getAllPublishers() {
        return this.getAllBooks().stream().map(Book::getPublisher).collect(Collectors.toSet());
    }

    public Set<Book> searchByAuthorName(String authorName) {
        List<Book> duplicateBooks = this.bookRepo.findByWrittenByNameContains(authorName);
        return new HashSet<>(duplicateBooks);
    }

    public Set<Book> getBookByAuthorId(int id) {
        List<Book> duplicateBooks = this.bookRepo.findByWrittenByIdOrderByName(id);
        return new HashSet<>(duplicateBooks);
    }
}
