package org.khasanof.examservice.examType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTypeCreateDTO {
    private String id;
    private String name;
    private String description;
}
