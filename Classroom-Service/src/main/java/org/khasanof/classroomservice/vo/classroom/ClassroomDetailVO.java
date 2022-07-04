package org.khasanof.classroomservice.vo.classroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.teacher.TeacherGetVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDetailVO extends GenericVO {
    private int year;
    private String gradeId;
    private String section;
    private boolean status;
    private String remarks;
    private TeacherGetVO teacher;
}
