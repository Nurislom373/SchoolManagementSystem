package org.khasanof.examservice.examResult.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.examservice.exam.dto.ExamGetDTO;
import reactor.core.publisher.Mono;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamResultDetailDTO {
    private ExamGetDTO exam;
    private StudentGetDTO student;
    private String courseId;
    private String marks;
}
