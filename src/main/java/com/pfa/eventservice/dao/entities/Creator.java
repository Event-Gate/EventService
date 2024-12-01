package com.pfa.eventservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
@Builder
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "creator")
    private List<Event> events = new ArrayList<>() ;


}
