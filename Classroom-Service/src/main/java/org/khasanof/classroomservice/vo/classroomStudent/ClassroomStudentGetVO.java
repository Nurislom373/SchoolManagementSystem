package org.khasanof.classroomservice.vo.classroomStudent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomStudentGetVO extends GenericVO {
    private String classroomId;
    private String studentId;
}
