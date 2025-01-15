package com.pfa.eventservice.service;

import com.pfa.eventservice.dao.entities.Creator;
import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dao.repositories.CategoryRepository;
import com.pfa.eventservice.dao.repositories.EventRepository;
import com.pfa.eventservice.dto.CreatorDto;
import com.pfa.eventservice.dto.EventDto;
import com.pfa.eventservice.mappers.EventMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService{


    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private CreatorService creatorService ;
    @Autowired
    private CategoryRepository categoryRepository ;




    @Override
    public EventDto createEvent(EventDto eventDto) {
        CreatorDto creator = creatorService.getCreatorByName(eventDto.getCreator().getName());

        Creator creator1 = new Creator();

        BeanUtils.copyProperties(creator,creator1);

        if (creator == null) {
            throw new RuntimeException("Creator not found");
        }

        Event event = eventMapper.convertEventDtoToEvent(eventDto);
        event.setCreator(creator1);

        Event savedEvent = eventRepository.save(event);

        return eventMapper.convertEventToEventDto(savedEvent);
    }
    @Override
    public EventDto getEventByID(Long id) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        return null  ;
    }

    @Override
    public List<Event> getEventsByLocation(String location) {
        return List.of();
    }

    @Override
    public void DeleteEvent(Long id) {

    }

    @Override
    public List<Event> getEventsByCategories(String category) {
        return eventRepository.findEventsByCategoryName(category);
    }
}
