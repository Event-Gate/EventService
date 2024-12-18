package com.pfa.eventservice;

import com.pfa.eventservice.dao.entities.Creator;
import com.pfa.eventservice.dao.repositories.CreatorRepository;
import com.pfa.eventservice.dao.repositories.EventRepository;
import com.pfa.eventservice.dto.CreatorDto;
import com.pfa.eventservice.service.CreatorService;
import com.pfa.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventServiceApplication {
    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private EventRepository eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            Creator creator1 = Creator.builder()
                    .name("John Doe")
                    .email("john.doe@example.com")
                    .build();

            Creator creator2 = Creator.builder()
                    .name("Jane Smith")
                    .email("jane.smith@example.com")
                    .build();

            creatorRepository.save(creator1);
            creatorRepository.save(creator2);


        };
    }
    }

