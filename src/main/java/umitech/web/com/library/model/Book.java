package umitech.web.com.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Book implements Comparable<Book> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer pages;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList", "addedOn"})
    private Author writtenBy;

    private String publisher;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"booksHeld"})
    private Student issuedBy;

    @UpdateTimestamp
    private Date updatedOn;

    @CreationTimestamp
    private Date createdOn;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties({"book"})
    List<Transaction> transactions;

    @Override
    public boolean equals(Object bc) {
        Book b = (Book) bc;
        return this.name.equals(b.name) && this.writtenBy.getEmail().equals(b.writtenBy.getEmail());
    }

    @Override
    public String toString(){
        return this.name + " By " + this.writtenBy.getName() + "(" + this.writtenBy.getEmail() + ")";
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int compareTo(Book o) {
        return this.toString().compareTo(o.toString());
    }

}
