package com.springboot.mygreetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from BridgeLabz - GET");
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from BridgeLabz - POST");
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from BridgeLabz - PUT");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from BridgeLabz - DELETE");
        return response;
    }

    //UC 2: Get a simple greeting
    @GetMapping("/simple")
    public String getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }

    // UC 3: Get a custom greeting based on first and last name
    @PostMapping("/custom")
    public String getCustomGreeting(@RequestBody GreetingMessage user) {
        return greetingService.getCustomGreeting(user);
    }

    // UC 5: Find a Greeting Message by Id
    @GetMapping("/{id}")
    public Optional<GreetingDetails> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    // UC 6: List all Greeting Messages
    @GetMapping("/all")
    public List<GreetingDetails> getAllGreetings() {
        return greetingService.findAllGreetings();
    }

    // UC 7: Edit a Greeting Message
    @PutMapping("/{id}")
    public GreetingDetails updateGreeting(@PathVariable Long id, @RequestBody String newMessage) {
        return greetingService.updateGreeting(id, newMessage);
    }

    // UC 8: Delete a Greeting Message
    @DeleteMapping("/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}