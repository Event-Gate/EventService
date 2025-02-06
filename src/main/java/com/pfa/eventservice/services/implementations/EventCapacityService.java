package com.pfa.eventservice.services.implementations;

import com.pfa.eventservice.dtos.EventCapacityRequest;
import com.pfa.eventservice.entities.Event;
import com.pfa.eventservice.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor @Slf4j
public class EventCapacityService {
    private final EventRepository eventRepository;

    @KafkaListener(topics = "${spring.kafka.topic.capacity-name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload EventCapacityRequest request) {
        try {
            log.info("Received event with id: {}", request.eventId());
            Event event = eventRepository.findById(request.eventId())
                    .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + request.eventId()));
            event.setCapacity(event.getCapacity() - 1);
            eventRepository.save(event);
        } catch (Exception e) {
            log.error("Error processing event: {}", e.getMessage(), e);
        }
    }
}
