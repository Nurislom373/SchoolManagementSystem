package org.khasanof.authservice.dto.student;

import lombok.*;
import org.khasanof.authservice.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDetailDTO extends GenericDTO {
    private String parent_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String status;
    private String dateOfJoin;
    private String lastLoginDate;
    private String lastLoginIp;
}
