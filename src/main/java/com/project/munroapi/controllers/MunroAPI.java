package com.project.munroapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunroAPI {
    @GetMapping("/munro-data")
    public ResponseEntity<Object> getMunro() {

        return ResponseEntity.ok("Hello world");
    }
}
