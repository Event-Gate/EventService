package com.pfa.eventservice.services.interfaces;

import com.pfa.eventservice.dtos.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service")
public interface UserServiceClient {
    @GetMapping("/api/auth/users/me")
    UserResponse getAuthenticatedUser(@RequestHeader("Authorization") String token);
}
