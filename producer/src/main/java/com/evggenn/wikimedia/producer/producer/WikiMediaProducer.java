package com.evggenn.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WikiMediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg) {

        kafkaTemplate.send("wikimedia-stream", msg);
    }

}
