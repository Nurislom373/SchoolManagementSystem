package org.khasanof.authservice.dto.parent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.authservice.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParentGetDTO extends GenericDTO {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String status;
}
