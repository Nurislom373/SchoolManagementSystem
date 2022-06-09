package org.khasanof.authservice.entity.teacher;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "teacher")
public class Teacher {
    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean status;
    private LocalDateTime lastLoginDate;
    private String lastLoginIp;
}
