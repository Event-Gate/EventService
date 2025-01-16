package com.pfa.eventservice.service.interfaces;

import com.pfa.eventservice.dtos.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceClient {
    @GetMapping("/api/auth/users/me")
    UserResponse getAuthenticatedUser(@RequestHeader("Authorization") String token);
}
