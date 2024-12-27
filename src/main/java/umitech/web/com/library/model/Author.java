package umitech.web.com.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Author implements Comparable<Author>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @Email
    @NotBlank
    @Size(max=255)
    @Column(unique = true)
    private String email;

    @CreationTimestamp
    private Date addedOn;

    @JsonIgnore
    @OneToMany(mappedBy = "writtenBy")
    @JsonIgnoreProperties({"writtenBy", "transactions", "issuedBy", "updatedOn", "createdOn" })
    private List<Book> bookList;

    @Override
    public int compareTo(Author o) {
        return this.email.compareTo(o.email);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
