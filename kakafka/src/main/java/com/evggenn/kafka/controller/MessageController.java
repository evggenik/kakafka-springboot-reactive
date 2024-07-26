package com.evggenn.kafka.controller;

import com.evggenn.kafka.payload.Student;
import com.evggenn.kafka.producer.KafkaJsonProducer;
import com.evggenn.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMsg(
            @RequestBody String msg
    ) {
        kafkaProducer.sendMessage(msg);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMsg(
            @RequestBody Student msg
    ) {
        kafkaJsonProducer.sendMessage(msg);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }

}
