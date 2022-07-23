package org.khasanof.attendanceservice.dto.student;

import lombok.*;
import org.khasanof.attendanceservice.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO extends GenericDTO {
    private String parent_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
