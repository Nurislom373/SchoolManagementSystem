package org.khasanof.classroomservice.vo.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseUpdateVO extends GenericVO {
    private String name;
    private String description;
    private String gradeId;
}
