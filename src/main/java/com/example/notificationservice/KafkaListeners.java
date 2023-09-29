package com.example.notificationservice;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "notification", groupId = "default")
    void listener(String data) {
        System.out.printf("received : %s%n", data);
    }
}
