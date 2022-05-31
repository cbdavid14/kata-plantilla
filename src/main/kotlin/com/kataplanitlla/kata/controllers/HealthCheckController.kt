package com.kataplanitlla.kata.controllers

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<Map<String, String>> {
        return ok(mapOf("status" to "Up"))
    }
}
