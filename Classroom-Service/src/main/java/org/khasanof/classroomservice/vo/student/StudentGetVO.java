package org.khasanof.classroomservice.vo.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentGetVO {
    private String id;
    private String parent_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
