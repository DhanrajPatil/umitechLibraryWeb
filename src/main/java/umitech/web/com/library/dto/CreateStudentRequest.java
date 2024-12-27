package umitech.web.com.library.dto;

import lombok.*;
import umitech.web.com.library.model.Student;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String contact;

    private String city;

    private String country;

    public Student to() {
        return Student.builder()
                .name(this.name)
                .email(this.email)
                .mobNo(this.contact)
                .address(this.city + ", " + this.country)
                .validity(new Date(System.currentTimeMillis() + 31536000000L))
                .build();
    }
}
