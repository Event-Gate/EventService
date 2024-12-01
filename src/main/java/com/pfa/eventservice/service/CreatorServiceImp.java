package com.pfa.eventservice.service;

import com.pfa.eventservice.dao.entities.Creator;
import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dao.repositories.CreatorRepository;
import com.pfa.eventservice.dao.repositories.EventRepository;
import com.pfa.eventservice.dto.CreatorDto;
import com.pfa.eventservice.mappers.CreatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorServiceImp implements CreatorService {

    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private CreatorMapper creatorMapper;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public CreatorDto getCreatorByName(String name) {

        Creator creator = creatorRepository.findByName(name);
        if (creator == null ) return null ;

        return creatorMapper.convertCreatorToDto(creator);
    }

    @Override
    public CreatorDto getCreatorByEmail(String email) {

        Creator creator = creatorRepository.findByEmail(email);
        if (creator == null ) return null ;


        return creatorMapper.convertCreatorToDto(creator);
    }

    @Override
    public CreatorDto createCreator(CreatorDto creatorDTO) {

        Creator creator = creatorMapper.convertCreatorDtoToCreator(creatorDTO);


        Creator savedCreator = creatorRepository.save(creator);


        return creatorMapper.convertCreatorToDto(savedCreator);
    }

    @Override
    public CreatorDto updateCreator(Long id, CreatorDto creatorDTO) {

        Creator existingCreator = creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creator not found with id: " + id));


        existingCreator.setName(creatorDTO.getName());
        existingCreator.setEmail(creatorDTO.getEmail());


        Creator updatedCreator = creatorRepository.save(existingCreator);


        return creatorMapper.convertCreatorToDto(updatedCreator);
    }

    @Override
    public List<Event> getAllEventByCreator(Long id) {
        return eventRepository.findEventsByCreatorId(id) ;
    }

    @Override
    public void deleteCreator(Long id) {

        Creator creator = creatorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Creator not found with id: " + id));


        creatorRepository.delete(creator);
    }
}