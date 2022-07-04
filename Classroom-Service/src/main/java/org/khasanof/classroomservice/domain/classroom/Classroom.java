package org.khasanof.classroomservice.domain.classroom;

import lombok.*;
import org.khasanof.classroomservice.domain.BaseEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "classroom")
public class Classroom implements BaseEntity {
    @Id
    private String id;
    @Min(value = 4, message = "year min value 4")
    private int year;
    @NotNull
    private String gradeId;
    @Size(min = 1, max = 2, message = "section min value 1 max value 2")
    private String section;
    private boolean status;
    @Size(max = 45, message = "remarks max value 45")
    private String remarks;
    @NotNull
    private String teacherId;
}
