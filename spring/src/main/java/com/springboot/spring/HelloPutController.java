package com.springboot.spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloPutController {

    @PutMapping("/hello/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName,
                              @RequestParam String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }
}
