package com.muhammederendemir.producer.controller;

import com.muhammederendemir.producer.dto.User;
import com.muhammederendemir.producer.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final KafkaProducerService service;

    public UserController(KafkaProducerService service) {
        this.service = service;
    }

    @PostMapping(value = "/sendUserTopic")
    public ResponseEntity sendUserTopic(@RequestBody User user){
        service.send(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}

