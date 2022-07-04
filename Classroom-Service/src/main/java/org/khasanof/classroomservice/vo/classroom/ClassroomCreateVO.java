package org.khasanof.classroomservice.vo.classroom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.BaseVO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomCreateVO implements BaseVO {
    private int year;
    private String gradeId;
    private String section;
    private boolean status;
    private String remarks;
    private String teacherId;
}
