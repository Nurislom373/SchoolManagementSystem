package org.khasanof.authservice.dto.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.authservice.dto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherCreateDTO implements BaseDTO {
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
