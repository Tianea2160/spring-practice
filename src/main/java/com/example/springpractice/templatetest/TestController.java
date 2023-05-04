package com.example.springpractice.templatetest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public String test(
            Model model,
            @RequestParam(value = "name", defaultValue = "world") String name
    ) {
        model.addAttribute("name", name);
        return "helloworld";
    }
}
