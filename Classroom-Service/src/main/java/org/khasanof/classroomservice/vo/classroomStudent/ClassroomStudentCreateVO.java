package org.khasanof.classroomservice.vo.classroomStudent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.BaseVO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomStudentCreateVO implements BaseVO {
    @NotNull(message = "classroom Id is null")
    private String classroomId;
    @NotNull(message = "student Id is null")
    private String studentId;
}
