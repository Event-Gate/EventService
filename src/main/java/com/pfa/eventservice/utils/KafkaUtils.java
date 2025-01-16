package com.pfa.eventservice.utils;

import com.pfa.eventservice.entities.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component @RequiredArgsConstructor @Slf4j
public class KafkaUtils {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topic;

    public void sendMessage(Event event, String token) {
        Message<Event> message = MessageBuilder
            .withPayload(event)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .setHeader(KafkaHeaders.KEY, event.getId())
            .setHeader("Authorization", "Bearer " + token)
            .build();

        kafkaTemplate.send(message)
            .whenComplete((result, ex) -> {
                if (ex == null) {
                    log.info("Event sent successfully");
                } else {
                    log.error("Failed to send event", ex);
                }
            });
    }
}
