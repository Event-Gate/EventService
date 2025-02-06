package com.pfa.eventservice.dtos;

import com.pfa.eventservice.enums.Status;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record EventRequest (
    String name,
    String location,
    LocalDateTime date,
    Status status,
    int capacity,
    LocalDateTime createdAt
) {}

