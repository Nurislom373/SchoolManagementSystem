package org.khasanof.attendanceservice.validator.attendance;

import org.khasanof.attendanceservice.dto.attendance.AttendanceCreateDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceUpdateDTO;
import org.khasanof.attendanceservice.exception.exceptions.InvalidValidationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AttendanceValidator {

    public void validOnCreate(AttendanceCreateDTO dto) {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    public void validOnUpdate(AttendanceUpdateDTO dto) {
        if (Objects.isNull(dto)) {
            throw new InvalidValidationException("DTO is null");
        }
    }

    public void validOnKey(String key) {
        if (Objects.isNull(key)) {
            throw new InvalidValidationException("ID is null");
        }
    }
}
