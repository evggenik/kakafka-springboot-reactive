package com.evggenn.wikimedia.consumer.consumer;

import com.evggenn.wikimedia.consumer.message.WikiMessage;
import com.evggenn.wikimedia.consumer.repo.MessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaConsumer {

    private final MessageRepository messageRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "wikimedia-stream", groupId = "myGroup")
    public void consumeMsg(String msg) throws JsonProcessingException {

        log.info(String.format("Consuming the message from wikimedia-stream Topic:: %s", msg));

        // TODO save data in db
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        WikiMessage wikiMessage = objectMapper.readValue(msg, WikiMessage.class);
        messageRepository.save(wikiMessage);
    }

}
