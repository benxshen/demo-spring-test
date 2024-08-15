package com.example.demo.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;

@RestController
public class DemoResource {

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/pub")
    public String pub() {
        return "Hello Pub";
    }
}
