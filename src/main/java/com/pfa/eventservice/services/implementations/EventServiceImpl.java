package com.pfa.eventservice.services.implementations;

import com.pfa.eventservice.dtos.EventRequest;
import com.pfa.eventservice.dtos.UserResponse;
import com.pfa.eventservice.entities.Event;
import com.pfa.eventservice.exceptions.UnauthorizedException;
import com.pfa.eventservice.repositories.EventRepository;
import com.pfa.eventservice.mappers.EventMapper;
import com.pfa.eventservice.services.interfaces.EventService;
import com.pfa.eventservice.services.interfaces.UserServiceClient;
import com.pfa.eventservice.utils.KafkaUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service @RequiredArgsConstructor @Slf4j
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final KafkaUtils kafkaUtils;
    private final UserServiceClient userServiceClient;

    @Override
    public Event createEvent(EventRequest request, String token) throws UnauthorizedException {
        UserResponse authenticatedUser = userServiceClient.getAuthenticatedUser("Bearer " + token);
        if (!authenticatedUser.isSeller()) {
            throw new UnauthorizedException("Only sellers can create an event.");
        }
        Event event = eventMapper.toEntity(request);
        event.setCreator(authenticatedUser.id());
        event.setCreatedAt(LocalDateTime.now());
        Event savedEvent = eventRepository.save(event);
        kafkaUtils.sendMessage(savedEvent, token);
        return savedEvent;
    }

    @Override
    public Event getEventById(String eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsByCreator(String creatorId) {
        return eventRepository.findAllByCreator(creatorId);
    }

    @Override
    public Event updateEvent(String eventId, EventRequest eventRequest, String token) throws UnauthorizedException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        UserResponse authenticatedUser = userServiceClient.getAuthenticatedUser("Bearer " + token);

        if (!event.getCreator().equals(authenticatedUser.id())) {
            throw new UnauthorizedException("You are not authorized to update this event");
        }

        event.setName(eventRequest.name());
        event.setLocation(eventRequest.location());
        event.setDate(eventRequest.date());
        event.setStatus(eventRequest.status());
        event.setCapacity(eventRequest.capacity());
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String eventId, String token) throws UnauthorizedException {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + eventId));

        UserResponse authenticatedUser = userServiceClient.getAuthenticatedUser("Bearer " + token);

        if (!event.getCreator().equals(authenticatedUser.id())) {
            throw new UnauthorizedException("You are not authorized to delete this event");
        }

        eventRepository.delete(event);
    }
}
