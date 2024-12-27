package umitech.web.com.library.dto;

import lombok.*;
import umitech.web.com.library.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateAuthorRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String country;

    public Author toAuthor() {
        return Author.builder()
                .email(this.email)
                .country(this.country)
                .name(this.name)
                .build();
    }
}
