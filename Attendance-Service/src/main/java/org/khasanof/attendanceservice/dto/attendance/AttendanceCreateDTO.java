package org.khasanof.attendanceservice.dto.attendance;

import lombok.*;
import org.khasanof.attendanceservice.dto.BaseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AttendanceCreateDTO implements BaseDTO {
    private String date;
    private String studentId;
    private String status;
    private String remarks;
}
