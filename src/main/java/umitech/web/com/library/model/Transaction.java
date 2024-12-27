package umitech.web.com.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus status;
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transactions"})
    private Book book;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"transactions"})
    private Student student;

    private double fine;
}
