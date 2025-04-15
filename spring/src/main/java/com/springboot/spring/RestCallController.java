package com.springboot.spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestCallController {

    // GET Request with path variable
    @GetMapping("/hello/param/{name}")
    public String helloWithPathVariable(@PathVariable String name) {
        return "Hello " + name + " from BridgeLabz";
    }
}
