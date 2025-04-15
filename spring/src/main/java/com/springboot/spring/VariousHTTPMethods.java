package com.springboot.spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class VariousHTTPMethods {

    // GET Request
    @GetMapping("/helloHTTP")
    public String sayHello() {
        return "Hello from BridgeLabz";
    }

    // POST Request
    @PostMapping("/helloUsingPost")
    public String postHello() {
        return "Hello from BridgeLabz - POST";
    }

    // PUT Request
    @PutMapping("/helloUsingPut")
    public String putHello() {
        return "Hello from BridgeLabz - PUT";
    }

    // DELETE Request
    @DeleteMapping("/helloDelete")
    public String deleteHello() {
        return "Hello from BridgeLabz - DELETE";
    }
}
