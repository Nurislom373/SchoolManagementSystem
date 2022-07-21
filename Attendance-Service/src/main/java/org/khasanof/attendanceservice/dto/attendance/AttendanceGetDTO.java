package org.khasanof.attendanceservice.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.khasanof.attendanceservice.dto.GenericDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceGetDTO extends GenericDTO {
    private String date;
    private String studentId;
    private String status;
    private String remarks;
}
