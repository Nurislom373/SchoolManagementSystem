package org.khasanof.classroomservice.vo.teacher;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherGetVO {
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String status;
}
