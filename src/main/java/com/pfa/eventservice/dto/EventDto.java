package com.pfa.eventservice.dto;

import java.time.LocalDateTime;

public class EventDto {
    private String name ;
    private String Location ;
    private LocalDateTime eventDate;
    private CreatorDto creator ;

    public EventDto(String name, String location, LocalDateTime eventDate, CreatorDto creator) {
        this.name = name;
        Location = location;
        this.eventDate = eventDate;
        this.creator = creator;
    }

    public EventDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public CreatorDto getCreator() {
        return creator;
    }

    public void setCreator(CreatorDto creator) {
        this.creator = creator;
    }
}
