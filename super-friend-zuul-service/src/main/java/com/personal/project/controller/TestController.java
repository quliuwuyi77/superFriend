package com.personal.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class TestController {

    @RequestMapping("/info")
    public String getMessage() {
        return "super friend zuul service is started success ! ";
    }

}