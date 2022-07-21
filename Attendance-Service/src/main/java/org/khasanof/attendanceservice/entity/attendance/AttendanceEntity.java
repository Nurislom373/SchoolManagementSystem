package org.khasanof.attendanceservice.entity.attendance;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "attendance")
public class AttendanceEntity {
    @Id
    private String id;
    private Date date;
    private String studentId;
    private String status;
    private String remarks;
}
