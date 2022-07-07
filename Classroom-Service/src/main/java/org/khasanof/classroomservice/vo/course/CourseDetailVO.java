package org.khasanof.classroomservice.vo.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;
import org.khasanof.classroomservice.vo.grade.GradeGetVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetailVO extends GenericVO {
    private String name;
    private String description;
    private GradeGetVO grade;
}
