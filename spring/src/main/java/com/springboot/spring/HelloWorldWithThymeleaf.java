package com.springboot.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldWithThymeleaf {

    @GetMapping("/hellousingthymeleaf")
    public String helloPage(Model model) {
        model.addAttribute("message", "Hello from Bridgelabz using Thymeleaf");
        return "hello";
    }
}
