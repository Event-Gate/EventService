package com.pfa.eventservice.mappers;

import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dto.EventDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {



    public Event convertEventDtoToEvent(EventDto eventDto)
    {
        if (eventDto == null )
        {
            return null ;
        }
        Event event = new Event() ;

        BeanUtils.copyProperties(eventDto,event);
        return event ;

    }

    public EventDto convertEventToEventDto(Event event)
    {
        if ( event == null )
        {
            return null ;
        }
        EventDto eventDto = new EventDto();
        BeanUtils.copyProperties(event, eventDto);
        return eventDto ;
    }
}
