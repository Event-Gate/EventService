package com.pfa.eventservice.entities;

import com.pfa.eventservice.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Event {
    @Id
    private String id;
    private String name;
    private String location;
    private LocalDateTime date;
    private Status status;
    private LocalDateTime createdAt = LocalDateTime.now();
    private int capacity;
    private String creator;
}
