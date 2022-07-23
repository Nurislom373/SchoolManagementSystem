package org.khasanof.attendanceservice.mapper.attendance;

import org.khasanof.attendanceservice.dto.attendance.AttendanceCreateDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceDetailDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceGetDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceUpdateDTO;
import org.khasanof.attendanceservice.entity.attendance.AttendanceEntity;
import org.khasanof.attendanceservice.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AttendanceMapper extends GenericMapper<AttendanceCreateDTO, AttendanceUpdateDTO, AttendanceGetDTO, AttendanceDetailDTO, AttendanceEntity> {
}
