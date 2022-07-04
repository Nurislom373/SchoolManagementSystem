package org.khasanof.classroomservice.vo.grade;

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
public class GradeCreateVO implements BaseVO {
    @NotNull
    private String name;
    @NotNull
    private String description;
}
