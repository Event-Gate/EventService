package com.pfa.eventservice.dtos;

import lombok.Builder;

@Builder
public record UserResponse(
        String id,
        String fullName,
        String email,
        boolean isSeller
) {}
