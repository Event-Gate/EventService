package com.pfa.eventservice.controllers.open;

import com.pfa.eventservice.entities.Event;
import com.pfa.eventservice.services.interfaces.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping("/api/public/events")
public class PublicEventController {
    private final EventService eventService;

    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable("eventId") String eventId) {
        return new ResponseEntity<>(eventService.getEventById(eventId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<List<Event>> getEventsByCreator(@PathVariable String creatorId) {
        return new ResponseEntity<>(eventService.getEventsByCreator(creatorId), HttpStatus.OK);
    }
}