package org.khasanof.classroomservice.vo.grade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.classroomservice.vo.GenericVO;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeUpdateVO extends GenericVO {
    @NotNull
    private String name;
    private String description;
}
