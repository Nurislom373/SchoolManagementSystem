package org.khasanof.attendanceservice.service.attendance;

import lombok.RequiredArgsConstructor;
import org.khasanof.attendanceservice.criteria.AttendanceCriteria;
import org.khasanof.attendanceservice.dto.attendance.AttendanceCreateDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceDetailDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceGetDTO;
import org.khasanof.attendanceservice.dto.attendance.AttendanceUpdateDTO;
import org.khasanof.attendanceservice.dto.student.StudentDTO;
import org.khasanof.attendanceservice.entity.attendance.AttendanceEntity;
import org.khasanof.attendanceservice.mapper.attendance.AttendanceMapper;
import org.khasanof.attendanceservice.repository.attendance.AttendanceRepository;
import org.khasanof.attendanceservice.response.Data;
import org.khasanof.attendanceservice.validator.attendance.AttendanceValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceMapper mapper;
    private final AttendanceRepository repository;

    private final AttendanceServiceClient client;
    private final AttendanceValidator validator;

    public void create(AttendanceCreateDTO dto) {
        validator.validOnCreate(dto);
        repository.save(mapper.toCreateDTO(dto));
    }

    public void update(AttendanceUpdateDTO dto) {
        validator.validOnUpdate(dto);
        AttendanceEntity attendance = repository.findById(dto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Attendance not found");
        });
        BeanUtils.copyProperties(dto, attendance, "id");
        repository.save(attendance);
    }

    public void delete(String id) {
        validator.validOnKey(id);
        AttendanceEntity attendance = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Attendance not found");
        });
        repository.delete(attendance);
    }

    public AttendanceGetDTO get(String id) {
        validator.validOnKey(id);
        return mapper.fromGetDTO(repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Attendance not found");
        }));
    }

    public AttendanceDetailDTO detail(String id) {
        validator.validOnKey(id);
        AttendanceEntity attendance = repository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Attendance not found");
        });
        AttendanceDetailDTO dto = new AttendanceDetailDTO();
        Data<StudentDTO> data = client.get(attendance.getStudentId());
        dto.setStudent(Objects.isNull(data.getData()) ? null : data.getData());
        BeanUtils.copyProperties(attendance, dto);
        return dto;
    }

    public List<AttendanceGetDTO> list(AttendanceCriteria criteria) {
        PageRequest pageRequest = PageRequest.of(criteria.getPage(), criteria.getSize());
        return mapper.fromGetListDTO(repository.findAll(pageRequest).stream().toList());
    }

    public List<AttendanceGetDTO> list(String status) {
        return mapper.fromGetListDTO(repository.findAllByStatusEquals(status));
    }

    public void deleteUser(String id) {
        validator.validOnKey(id);
        List<AttendanceEntity> all = repository.findAllByStudentIdEquals(id);
        if (all.isEmpty()) {
            throw new NotFoundException("Attendance not found");
        } else {
            repository.deleteAll(all);
        }
    }
}
