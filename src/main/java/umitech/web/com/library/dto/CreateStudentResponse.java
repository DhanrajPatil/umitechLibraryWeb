package umitech.web.com.library.dto;

import lombok.*;
import umitech.web.com.library.model.Student;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateStudentResponse {
    private String status;
    private String message;
    private Student stud;
}
