package com.pfa.eventservice.web;

import com.pfa.eventservice.dto.CreatorDto;
import com.pfa.eventservice.service.CreatorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CreatorController {

    private final CreatorService creatorService;

    public CreatorController(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    // Endpoint to create a new Creator
    @PostMapping
    public ResponseEntity<CreatorDto> createCreator(@Valid @RequestBody CreatorDto creatorDto) {
        CreatorDto createdCreator = creatorService.createCreator(creatorDto);
        return new ResponseEntity<>(createdCreator, HttpStatus.CREATED);
    }



    // Endpoint to get Creator by Name
    @GetMapping("/name/{name}")
    public ResponseEntity<CreatorDto> getCreatorByName(@PathVariable String name) {
        CreatorDto creatorDto = creatorService.getCreatorByName(name);
        return creatorDto != null ? ResponseEntity.ok(creatorDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Endpoint to get Creator by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<CreatorDto> getCreatorByEmail(@PathVariable String email) {
        CreatorDto creatorDto = creatorService.getCreatorByEmail(email);
        return creatorDto != null ? ResponseEntity.ok(creatorDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Endpoint to update Creator by ID
    /*PutMapping("/{id}")
    public ResponseEntity<CreatorDto> updateCreator(@PathVariable Long id, @Valid @RequestBody CreatorDto creatorDto) {
        Optional<CreatorDto updatedCreator = creatorService.updateCreator(id, creatorDto);
        return updatedCreator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Endpoint to delete Creator by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreator(@PathVariable Long id) {
        boolean deleted = creatorService.deleteCreator(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }*/
}
