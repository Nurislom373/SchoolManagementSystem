package org.khasanof.attendanceservice.service.attendance;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceConsumerService {

    private final AttendanceService attendanceService;

    @KafkaListener(topics = "auth", groupId = "0", containerFactory = "kafkaListenerContainerFactory")
    public void consumeAuth(String id) {
        attendanceService.deleteUser(id.substring(1, id.length() - 1));
    }
}
