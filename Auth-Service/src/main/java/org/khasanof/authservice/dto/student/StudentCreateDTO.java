package org.khasanof.authservice.dto.student;

import lombok.*;
import org.khasanof.authservice.dto.BaseDTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentCreateDTO implements BaseDTO {
    @Size(min = 10, max = 120, message = "{student.email.size}")
    @NotBlank(message = "{student.email.required}")
    private String email;

    @Size(min = 8, max = 300, message = "{student.password.size}")
    @NotBlank(message = "{student.password.required}")
    private String password;

    @Size(min = 3, max = 120, message = "{student.firstName.size}")
    @NotBlank(message = "{student.firstName.required}")
    private String firstName;

    @Size(min = 3, max = 120, message = "{student.lastName.size}")
    @NotBlank(message = "{student.lastName.required}")
    private String lastName;

    @Size(min = 12, max = 12, message = "{student.firstName.size}")
    @NotBlank(message = "{student.firstName.required}")
    private String phone;

    @Min(value = 1, message = "{student.parentId.min}")
    @NotBlank(message = "{student.parentId.required}")
    private int parentId;


    private LocalDateTime dateOfJoin;
    private boolean status;
    private LocalDateTime lastLoginDate;
    private String lastLoginIp;
}
