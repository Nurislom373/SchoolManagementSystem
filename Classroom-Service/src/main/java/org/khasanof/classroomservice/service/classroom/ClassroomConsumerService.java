package org.khasanof.classroomservice.service.classroom;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassroomConsumerService {

    private final ClassroomService classroomService;

    @KafkaListener(topics = "auth", groupId = "0", containerFactory = "kafkaListenerContainerFactory")
    public void classroomConsume(String id) {
        classroomService.deleteUserId(id.substring(1, id.length() - 1));
    }
}
