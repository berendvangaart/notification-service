package com.example.notificationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner clr(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("notification", "hello kafka <3");
		};
	}
}
