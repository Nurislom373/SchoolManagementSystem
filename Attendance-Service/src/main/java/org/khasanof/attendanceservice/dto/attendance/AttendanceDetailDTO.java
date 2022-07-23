package org.khasanof.attendanceservice.dto.attendance;

import lombok.*;
import org.khasanof.attendanceservice.dto.GenericDTO;
import org.khasanof.attendanceservice.dto.student.StudentDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AttendanceDetailDTO extends GenericDTO {
    private String date;
    private StudentDTO student;
    private String status;
    private String remarks;
    private boolean isDeleted;
    private LocalDateTime createdAt;
    private Integer createdBy;
    private LocalDateTime updatedAt;
    private Integer updatedBy;
}
