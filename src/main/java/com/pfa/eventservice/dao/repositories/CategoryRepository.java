package com.pfa.eventservice.dao.repositories;

import com.pfa.eventservice.dao.entities.Category;
import com.pfa.eventservice.dao.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long > {
    List<Event> findCategoriesByName(String category);
}
