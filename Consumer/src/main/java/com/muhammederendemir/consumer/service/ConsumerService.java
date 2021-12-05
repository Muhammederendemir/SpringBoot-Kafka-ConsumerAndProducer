package com.muhammederendemir.consumer.service;

import com.muhammederendemir.consumer.model.User;
import com.muhammederendemir.consumer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final UserRepository userRepository;

    @KafkaListener(
            topics = "UserTopic",
            groupId = "group-id"
    )
    public void saveUser(@Payload User user){
        userRepository.save(user);
    }
}