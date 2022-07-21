package org.khasanof.attendanceservice.repository.attendance;

import org.khasanof.attendanceservice.entity.attendance.AttendanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends MongoRepository<AttendanceEntity, String> {
}
