package org.app.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService  {

    private final KafkaTemplate<String,String> kafkaTemplate;

    // Post API
    public void sendEmployeeCreated(String message)
    {
        kafkaTemplate.send("employee-topic",message);
        System.out.println("[KAFKA PRODUCER - CREATE]:Message sent to topic ->"+message);
    }

    // Delete API
    public void sendEmployeeDeleted(String message)
    {
        kafkaTemplate.send("employee-topic",message);
        System.out.println("[KAFKA PRODUCER - DELETE]: Message sent to topic ->"+message);
    }

    // Put API
    public void sendEmployeeUpdateAll(String message)
    {
        kafkaTemplate.send("employee-topic",message);
        System.out.println("[KAFKA PRODUCER - UPDATE]: Message sent to topic ->"+message);
    }

}
