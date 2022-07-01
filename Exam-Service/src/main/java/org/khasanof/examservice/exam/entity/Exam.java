package org.khasanof.examservice.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exam")
public class Exam {
    private String id;
    private String examTypeId;
    private String name;
    private String startDate;
}
