package com.springboot.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldUsingRest {
    @GetMapping("/hellousingrest")
    public String sayHello() {
        return "Hello from BridgeLabz using rest controller";
    }
}
