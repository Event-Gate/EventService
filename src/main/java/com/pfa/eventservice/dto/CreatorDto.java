package com.pfa.eventservice.dto;

import lombok.Builder;

@Builder
public class CreatorDto {

    private String name ;
    private String email ;

    public CreatorDto(){}

    public CreatorDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
