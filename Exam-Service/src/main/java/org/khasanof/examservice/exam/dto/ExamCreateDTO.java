package org.khasanof.examservice.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamCreateDTO {
    private String examTypeId;
    private String name;
    private String startDate;
}
