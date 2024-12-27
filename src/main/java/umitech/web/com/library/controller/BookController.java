package umitech.web.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umitech.web.com.library.dto.CreateBookRequest;
import umitech.web.com.library.model.Book;
import umitech.web.com.library.service.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping ("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public Book createBook(@RequestBody @Valid CreateBookRequest bookReq) {
        return this.bookService.createBook(bookReq);
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable("bookId") int bookId) {
        return bookService.delete(bookId);
    }

    @GetMapping("/searchByTitle/{bookTitle}")
    public List<Book> searchByTitle(@PathVariable("bookTitle") String title) {
        return bookService.searchByTitle(title);
    }

    @GetMapping("/searchByPublisher/{publisherName}")
    public List<Book> searchByPublisher(@PathVariable("publisherName") String publisherName) {
        return bookService.searchByPublisher(publisherName);
    }

    @GetMapping("/all")
    public Set<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/all/publishers")
    public Set<String> getAllPublishers() {
        return bookService.getAllPublishers();
    }

    @GetMapping("/searchByAuthor/{authorName}")
    public Set<Book> getBooksByAuthorName(@PathVariable("authorName") String authorName) {
        return bookService.searchByAuthorName(authorName);
    }
}
