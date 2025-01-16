package com.pfa.eventservice.controllers.auth;

import com.pfa.eventservice.dtos.EventRequest;
import com.pfa.eventservice.entities.Event;
import com.pfa.eventservice.exceptions.UnauthorizedException;
import com.pfa.eventservice.service.interfaces.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/api/auth/events")
public class AuthEventController {
    private final EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequest request, @RequestHeader("Authorization") String header) {
        String token = header.startsWith("Bearer ") ? header.substring(7) : header;
        return new ResponseEntity<>(eventService.createEvent(request, token), HttpStatus.OK);
    }

    @PutMapping("/update/{eventId}")
    public ResponseEntity<Event> updateEvent(@PathVariable String eventId, @RequestBody EventRequest request, @RequestHeader("Authorization") String header) throws UnauthorizedException {
        String token = header.startsWith("Bearer ") ? header.substring(7) : header;
        return new ResponseEntity<>(eventService.updateEvent(eventId, request, token), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Void> updateEvent(@PathVariable String eventId, @RequestHeader("Authorization") String header) throws UnauthorizedException {
        String token = header.startsWith("Bearer ") ? header.substring(7) : header;
        eventService.deleteEvent(eventId, token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}