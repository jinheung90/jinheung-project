package com.jinheung.project;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final Environment env;


    @GetMapping("/test")
    public String profile() {
        return "test";
    }
}
