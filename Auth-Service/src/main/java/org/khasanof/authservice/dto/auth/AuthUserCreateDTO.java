package org.khasanof.authservice.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.authservice.dto.BaseDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDTO implements BaseDTO {
    @NotNull(message = "role required")
    private String role;
    private String parent_id;
    @NotNull(message = "email required")
    @Size(min = 9, max = 120, message = "email min size 12 max size 120")
    private String email;
    @NotNull(message = "password required")
    @Size(min = 3, max = 120, message = "password min size 12 max size 120")
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String dateOfJoin;
    private String lastLoginDate;
    private String lastLoginIp;
}
