package org.khasanof.classroomservice.domain.course;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "course")
@ToString
public class Course {
    @Id
    private String id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private String gradeId;
}
