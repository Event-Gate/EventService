package com.pfa.eventservice.web;

import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dto.EventDto;
import com.pfa.eventservice.service.EventProducer;
import com.pfa.eventservice.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventProducer eventProducer;
    private final EventService eventService ;

    public EventController(EventProducer eventProducer, EventService eventService) {
        this.eventProducer = eventProducer;
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<String> createEventKafka(@RequestBody EventDto event) {
        eventProducer.sendEvent(event);
        return ResponseEntity.ok("Event published successfully.");
    }

    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto) {
        try {
            EventDto createdEvent = eventService.createEvent(eventDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}