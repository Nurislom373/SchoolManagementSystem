package org.khasanof.examservice.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamGetDTO {
    private String id;
    private String examTypeId;
    private String name;
    private String startDate;
}
