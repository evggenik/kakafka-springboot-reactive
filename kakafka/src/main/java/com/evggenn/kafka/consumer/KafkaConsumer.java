package com.evggenn.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "evggenn", groupId = "myGroup")
    public void consumeMsg(String msg) {

        log.info(String.format("Consuming the message from evggenn Topic:: %s", msg));

    }

}
