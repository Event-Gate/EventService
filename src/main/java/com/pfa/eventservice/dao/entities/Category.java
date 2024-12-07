package com.pfa.eventservice.dao.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description ;

    @OneToMany(mappedBy="category")
    private List<Event> events = new ArrayList<>();

}
