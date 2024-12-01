package com.pfa.eventservice.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private LocalDateTime eventDate;

    @ManyToOne
    private Creator creator ;
}
