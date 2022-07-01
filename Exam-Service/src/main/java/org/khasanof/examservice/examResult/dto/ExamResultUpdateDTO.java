package org.khasanof.examservice.examResult.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResultUpdateDTO {
    private String id;
    private String examId;
    private String studentId;
    private String courseId;
    private String marks;
}
