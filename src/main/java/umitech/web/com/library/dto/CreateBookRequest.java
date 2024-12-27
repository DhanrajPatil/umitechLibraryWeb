package umitech.web.com.library.dto;

import lombok.*;
import umitech.web.com.library.model.Author;
import umitech.web.com.library.model.Book;
import umitech.web.com.library.model.Genre;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {
    @NotBlank
    private String name;

    @NotNull
    private Genre genre;

    private Integer pages;

    @NotBlank
    private String publisher;

    @NotBlank
    private String authorName;

    private String authorCountry;

    @NotBlank
    private String authorEmail;

    public Book to() {
        return Book.builder()
                .name(this.name)
                .pages(this.pages)
                .genre(this.genre)
                .publisher(this.publisher)
                .writtenBy(
                        Author.builder()
                                .name(this.authorName)
                                .country(this.authorCountry)
                                .email(this.authorEmail)
                                .build()
                )
                .build();
    }

}
