package umitech.web.com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import umitech.web.com.library.model.Author;
import umitech.web.com.library.model.Book;
import umitech.web.com.library.repository.AuthorRepository;
import umitech.web.com.library.repository.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authRepo;

    @Autowired
    BookRepository bookRepo;

    public Author createOrGet(Author authReq) {
        Author auth = authRepo.findByEmail(authReq.getEmail());
        if(auth != null) {
            return auth;
        }
        return this.authRepo.save(authReq);
    }

    public List<Author> getAll() {
        Sort sortBy = Sort.by(Sort.Direction.DESC, "id");
        return this.authRepo.findAll(sortBy);
    }

    public Author getAuthorByEmail(String email) {
        return this.authRepo.findByEmail(email);
    }

    public Set<Author> getAuthorByName(String name) {
        List<Author> authors = this.authRepo.findByNameContains(name);
        return new HashSet<>(authors);
    }

    public Author getAuthorById(int id) {
        return this.authRepo.findById(id).orElse(null);
    }

    public Set<Book> getAuthorsAllBook(int id) {
        List<Book> books = this.bookRepo.findByWrittenByIdOrderByName(id);
        Comparator<Book> bookComparator = (b1, b2) -> {

            return b1.getName().compareTo(b2.getName())
        }
        return new TreeSet<>(books);
    }
}
