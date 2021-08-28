package com.project.munroapi.controllers;

import com.project.munroapi.helpers.Validation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunroAPI {
    @GetMapping("/munro-data")
    public ResponseEntity<Object> getMunro(
            @RequestParam(required = false) String hill,
            @RequestParam(required = false) String height,
            @RequestParam(required = false) String alpha,
            @RequestParam(required = false) String min,
            @RequestParam(required = false) String max,
            @RequestParam(required = false) String limit) {

        if (!Validation.paramsValid(hill, height, alpha, min, max, limit)) return Validation.errorResponse();

        return ResponseEntity.ok("Hello world");
    }
}
