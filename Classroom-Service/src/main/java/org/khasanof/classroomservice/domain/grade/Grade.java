package org.khasanof.classroomservice.domain.grade;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "grade")
public class Grade {
    @Id
    private String id;
    @NotNull
    private String name;
    private String description;
}
