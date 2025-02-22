package com.pfa.eventservice.mappers;

import com.pfa.eventservice.dtos.EventRequest;
import com.pfa.eventservice.entities.Event;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EventMapper {

    public Event toEntity(EventRequest eventRequest) {
        return Event.builder()
                .name(eventRequest.name())
                .location(eventRequest.location())
                .date(eventRequest.date())
                .status(eventRequest.status())
                .capacity(eventRequest.capacity())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public EventRequest toRequest(Event event) {
        return EventRequest.builder()
                .name(event.getName())
                .location(event.getLocation())
                .date(event.getDate())
                .status(event.getStatus())
                .capacity(event.getCapacity())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
