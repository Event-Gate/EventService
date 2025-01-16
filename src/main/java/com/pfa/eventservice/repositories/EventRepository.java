package com.pfa.eventservice.repositories;

import com.pfa.eventservice.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findAllByCreator(String creatorId);
}
