package org.khasanof.attendanceservice.dto.attendance;

import lombok.*;
import org.khasanof.attendanceservice.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AttendanceDetailDTO extends GenericDTO {
    private String date;
    private String studentId;
    private String status;
    private String remarks;
}
