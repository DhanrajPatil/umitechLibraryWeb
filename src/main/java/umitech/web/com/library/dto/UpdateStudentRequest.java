package umitech.web.com.library.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateStudentRequest {

    private String contact;

    private String email;

    private String address;

    private boolean extendValidityByYear;

}
