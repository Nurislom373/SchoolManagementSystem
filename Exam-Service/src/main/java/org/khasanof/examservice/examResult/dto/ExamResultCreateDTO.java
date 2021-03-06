package org.khasanof.examservice.examResult.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResultCreateDTO {
    private String examId;
    private String studentId;
    private String courseId;
    private String marks;
}
