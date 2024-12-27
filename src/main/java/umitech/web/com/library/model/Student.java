package umitech.web.com.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student implements Comparable<Student>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    private String address;

    @NotBlank
    @Size(min = 7, max = 15)
    @Column(unique = true)
    private String mobNo;

    @Email
    @NotBlank
    private String email;

    private Date validity;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "issuedBy")
    @JsonIgnoreProperties({"issuedBy", "transactions"})
    private List<Book> booksHeld;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties({"student"})
    private List<Transaction> transactions;

    @Override
    public int compareTo(Student o) {
        return this.email.compareTo(o.email);
    }
}
