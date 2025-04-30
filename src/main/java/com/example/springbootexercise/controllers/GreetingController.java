package com.example.springbootexercise.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class GreetingController {
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "SuccessHeader");
        return new ResponseEntity<>("Request was successful!", headers, HttpStatus.OK);
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return new ResponseEntity<>("Resource not found!", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        URI location = URI.create("/resource/123");
        return ResponseEntity.created(location).body("Resource created!");
    }

}
