package com.bookfast.bookfast_backend.controller;

import com.bookfast.bookfast_backend.dto.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public HelloResponse hello() {
        return new HelloResponse(
                "Welcome to BookFast!",
                "UP"
        );
    }
}