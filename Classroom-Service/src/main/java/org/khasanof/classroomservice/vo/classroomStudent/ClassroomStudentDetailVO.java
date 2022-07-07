package org.khasanof.classroomservice.vo.classroomStudent;

import lombok.*;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.classroom.ClassroomGetVO;
import org.khasanof.classroomservice.vo.student.StudentGetVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomStudentDetailVO extends GenericVO {
    private StudentGetVO student;
    private ClassroomGetVO classroom;
}
