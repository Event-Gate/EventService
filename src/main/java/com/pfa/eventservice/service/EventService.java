package com.pfa.eventservice.service;

import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dto.EventDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {

    EventDto createEvent(EventDto eventDto);

    EventDto getEventByID(Long id ) ;

    List<Event> getAllEvents();

    EventDto updateEvent(Long id , EventDto eventDto) ;

    List<Event> getEventsByLocation(String location) ;

    void DeleteEvent(Long id );


}
