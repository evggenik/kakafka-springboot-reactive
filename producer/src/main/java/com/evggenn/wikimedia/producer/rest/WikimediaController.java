package com.evggenn.wikimedia.producer.rest;

import com.evggenn.wikimedia.producer.producer.WikiMediaProducer;
import com.evggenn.wikimedia.producer.stream.WikimediaStreamConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wikimedia")
public class WikimediaController {

    private final WikimediaStreamConsumer streamConsumer;

    @GetMapping
    public void startPublish() {
        streamConsumer.consumeStreamAndPublish();
    }

}
