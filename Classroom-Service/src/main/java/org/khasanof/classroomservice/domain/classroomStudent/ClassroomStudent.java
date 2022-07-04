package org.khasanof.classroomservice.domain.classroomStudent;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "classroomStudent")
public class ClassroomStudent {
    @Id
    private String id;
    @NotNull
    private String classroomId;
    @NotNull
    private String studentId;
}
