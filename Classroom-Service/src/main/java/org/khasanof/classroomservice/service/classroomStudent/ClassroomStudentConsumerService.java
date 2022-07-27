package org.khasanof.classroomservice.service.classroomStudent;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomStudentConsumerService {

    private final ClassroomStudentService studentService;

    @KafkaListener(topics = "auth", groupId = "0", containerFactory = "kafkaListenerContainerFactory")
    public void classroomStudentConsume(String id) {
        studentService.deleteUserId(id.substring(1, id.length() - 1));
    }
}
