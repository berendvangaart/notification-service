package com.example.notificationservice.controller;

import com.example.notificationservice.model.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/notification")
public class NotificationController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public NotificationController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> publish(@RequestBody Notification notification) {
        kafkaTemplate.send("notification", notification.message());
        return ResponseEntity.ok().build();
    }



}
