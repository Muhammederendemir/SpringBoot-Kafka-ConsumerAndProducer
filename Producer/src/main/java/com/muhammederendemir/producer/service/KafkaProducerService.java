package com.muhammederendemir.producer.service;

import com.muhammederendemir.producer.dto.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaProducerService {

    private static final String TOPIC_NAME = "UserTopic";

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(User user){
        kafkaTemplate.send(TOPIC_NAME, UUID.randomUUID().toString(), user);
    }
}