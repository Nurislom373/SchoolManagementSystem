package org.khasanof.examservice.examType.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamTypeUpdateDTO {
    private String id;
    private String name;
    private String description;
}
