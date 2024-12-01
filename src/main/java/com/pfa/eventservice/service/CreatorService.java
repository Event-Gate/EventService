package com.pfa.eventservice.service;

import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dto.CreatorDto;

import java.util.List;

public interface CreatorService {

    CreatorDto getCreatorByName(String name);


    CreatorDto getCreatorByEmail(String email);


    CreatorDto createCreator(CreatorDto CreatorDto);


    CreatorDto updateCreator(Long id, CreatorDto CreatorDto);

    List<Event> getAllEventByCreator (Long id);
    void deleteCreator(Long id);
}