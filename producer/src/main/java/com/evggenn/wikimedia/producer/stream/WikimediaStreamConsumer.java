package com.evggenn.wikimedia.producer.stream;

import com.evggenn.wikimedia.producer.producer.WikiMediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
//@RequiredArgsConstructor
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikiMediaProducer producer;

    public WikimediaStreamConsumer(WebClient.Builder webClient, WikiMediaProducer producer) {
        this.webClient = webClient.baseUrl("https://stream.wikimedia.org/v2").build();
        this.producer = producer;
    }


    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMsg);
    }

}
