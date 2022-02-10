package com.jinheung.project.domain.user.controller;

import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/resource")
public class UserController {
    @GetMapping
    public ResponseEntity<String> getResource(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok("test");
    }
}
