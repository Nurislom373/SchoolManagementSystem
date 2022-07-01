package org.khasanof.examservice.examResult.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exam_result")
public class ExamResult {
    @Id
    private String id;
    private String examId;
    private String studentId;
    private String courseId;
    private String marks;
}
