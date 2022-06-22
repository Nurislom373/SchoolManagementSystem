package org.khasanof.authservice.dto.parent;

import lombok.*;
import org.khasanof.authservice.dto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentCreateDTO implements BaseDTO {
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
