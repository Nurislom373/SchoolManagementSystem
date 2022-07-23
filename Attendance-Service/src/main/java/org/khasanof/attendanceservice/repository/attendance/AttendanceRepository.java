package org.khasanof.attendanceservice.repository.attendance;

import org.khasanof.attendanceservice.entity.attendance.AttendanceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends MongoRepository<AttendanceEntity, String> {
    List<AttendanceEntity> findAllByStatusEquals(String status);

    List<AttendanceEntity> findAllByStudentIdEquals(String id);
}
