package com.pfa.eventservice.services.interfaces;

import com.pfa.eventservice.dtos.EventRequest;
import com.pfa.eventservice.entities.Event;
import com.pfa.eventservice.exceptions.UnauthorizedException;

import java.util.List;

public interface EventService {
    Event createEvent(EventRequest eventRequest, String token) throws UnauthorizedException;
    List<Event> getAllEvents();
    List<Event> getEventsByCreator(String creatorId);
    Event getEventById(String eventId);
    Event updateEvent(String eventId, EventRequest eventRequest, String token) throws UnauthorizedException;
    void deleteEvent(String eventId, String token) throws UnauthorizedException;
}
