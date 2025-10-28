package com.example.demo_8.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String home() {
        return "Välkommen till startsidan!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin() {
        return "Hej Admin!";
    }

    @GetMapping("/todos")
    @PreAuthorize("hasAuthority('READ_TODO')")
    public String getTodos() {
        return "Här är alla dina todos!";
    }
}

