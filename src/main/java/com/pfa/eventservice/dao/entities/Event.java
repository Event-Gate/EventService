package com.pfa.eventservice.dao.entities;

import com.pfa.eventservice.dao.entities.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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
    private Status status ;
    private Date created_at ;
    private Integer capacity;

    @ManyToOne
    private Creator creator ;

    @ManyToOne
    private Category category ;

}
