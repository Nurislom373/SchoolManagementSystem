package org.khasanof.classroomservice.vo.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.BaseVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreateVO implements BaseVO {
    private String name;
    private String description;
    private String gradeId;
}
