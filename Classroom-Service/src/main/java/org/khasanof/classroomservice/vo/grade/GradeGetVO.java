package org.khasanof.classroomservice.vo.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeGetVO extends GenericVO {
    private String name;
    private String description;
}
