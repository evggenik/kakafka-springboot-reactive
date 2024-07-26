package com.evggenn.kafka.consumer;

import com.evggenn.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "evggenn", groupId = "myGroup")
    public void consumeMsg(String msg) {

        log.info(String.format("Consuming the message from evggenn Topic:: %s", msg));

    }

    @KafkaListener(topics = "evggenn", groupId = "myGroup")
    public void consumeJsonMsg(Student student) {
        log.info(String.format("Consuming the message from evggenn Topic:: %s", student.toString()));
    }

}
