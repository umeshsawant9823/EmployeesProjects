package org.app.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "employee-topic", groupId = "employee-group")
    public void ConsumeEmployeeEvent(String message)
    {
        System.out.println("[KAFKA CONSUMER]: Received message Successfully ->"+message);
    }
}
