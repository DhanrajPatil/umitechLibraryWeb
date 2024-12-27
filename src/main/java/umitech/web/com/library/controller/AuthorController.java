package umitech.web.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umitech.web.com.library.dto.CreateAuthorRequest;
import umitech.web.com.library.model.Author;
import umitech.web.com.library.model.Book;
import umitech.web.com.library.repository.AuthorRepository;
import umitech.web.com.library.service.AuthorService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("")
    public Author createAuthor(@RequestBody @Valid CreateAuthorRequest authorReq) {
        Author author = authorReq.toAuthor();
        return this.authorService.createOrGet(author);
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors(){
        return this.authorService.getAll();
    }

    @GetMapping("/searchByEmail/{email}")
    public Author getAuthorByEmail(@PathVariable("email") String email){
        return this.authorService.getAuthorByEmail(email);
    }

    @GetMapping("/{id}")
    public Author getAuthorByEmail(@PathVariable("id") Integer id){
        return this.authorService.getAuthorById(id);
    }

    @GetMapping("/searchByName/{name}")
    public Set<Author> getAuthorByName(@PathVariable("name") String name){
        return this.authorService.getAuthorByName(name);
    }

    @GetMapping("/{id}/allBooks")
    public Set<Book> getAuthorByName(@PathVariable("id") int id){
        return this.authorService.getAuthorsAllBook(id);
    }

}
