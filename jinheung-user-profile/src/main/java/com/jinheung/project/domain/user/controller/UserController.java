package com.jinheung.project.domain.user.controller;


import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class UserController {

    @GetMapping("/resource")
    public ResponseEntity<String> getUserAuthority(String token) {
        return ResponseEntity.ok("get ");
    }
}
