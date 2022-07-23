package org.khasanof.attendanceservice.entity.attendance;

import lombok.*;
import org.khasanof.attendanceservice.entity.Auditable;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "attendance")
public class AttendanceEntity extends Auditable {
    private String date;
    private String studentId;
    private String status;
    private String remarks;
}
