package org.khasanof.examservice.examResult;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamResultConsumerService {

    private final ExamResultService resultService;

    @KafkaListener(topics = "auth", groupId = "0", containerFactory = "kafkaListenerContainerFactory")
    public void examResultConsume(String id) {
        resultService.deleteUser(id.substring(1, id.length() - 1));
    }
}
