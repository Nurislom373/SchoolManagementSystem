package org.khasanof.authservice.entity.student;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student")
public class Student {
    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private int parentId;
    private LocalDateTime dateOfJoin;
    private boolean status;
    private LocalDateTime lastLoginDate;
    private String lastLoginIp;

}
