package com.springboot.mygreetings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    // UC 5: Find a Greeting Message by Id
    public Optional<GreetingDetails> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    // UC 6: List all Greeting Messages
    public List<GreetingDetails> findAllGreetings() {
        return greetingRepository.findAll();
    }

    // UC 7: Edit a Greeting Message
    public GreetingDetails updateGreeting(Long id, String newMessage) {
        GreetingDetails greeting = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found"));
        greeting.setGreetingMessage(newMessage);
        return greetingRepository.save(greeting);
    }

    // UC 8: Delete a Greeting Message
    public void deleteGreeting(Long id) {
        greetingRepository.deleteById(id);
    }

    // UC 2: Simple greeting
    public String getSimpleGreeting() {
        return "Hello from BridgeLabz";
    }

    // UC 3: Custom greeting with first and last name
    public String getCustomGreeting(GreetingMessage user) {
        String greeting = "Hello";
        if (user.getFirstName() != null && user.getLastName() != null) {
            greeting += " " + user.getFirstName() + " " + user.getLastName();
        } else if (user.getFirstName() != null) {
            greeting += " " + user.getFirstName();
        } else if (user.getLastName() != null) {
            greeting += " " + user.getLastName();
        } else {
            greeting += " World";
        }

        // Save the greeting to the repository
        GreetingDetails newGreeting = new GreetingDetails();
        newGreeting.setGreetingMessage(greeting + " from BridgeLabz");
        greetingRepository.save(newGreeting);

        return greeting + " from BridgeLabz";
    }
}
