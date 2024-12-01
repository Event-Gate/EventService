package com.pfa.eventservice.dao.repositories;

import com.pfa.eventservice.dao.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findEventsByCreatorId(Long id );
}
