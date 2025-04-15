package com.springboot.spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestCall {

    @GetMapping("/helloQuery/query")
    public String helloQuery(@RequestParam String name) {
        return "Hello " + name + " from BridgeLabz";
    }
}
