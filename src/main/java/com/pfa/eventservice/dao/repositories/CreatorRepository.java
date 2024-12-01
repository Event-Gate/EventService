package com.pfa.eventservice.dao.repositories;

import com.pfa.eventservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator,Long> {
    public Creator findByName(String name) ;


    Creator findByEmail(String email);
}
