package com.pfa.eventservice.service;

import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dto.EventDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class EventProducer {

        private final KafkaTemplate<String, EventDto> kafkaTemplate;

        public EventProducer(KafkaTemplate<String, EventDto> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        public void sendEvent(EventDto event) {
            kafkaTemplate.send("event-topic", event);
        }
    }


