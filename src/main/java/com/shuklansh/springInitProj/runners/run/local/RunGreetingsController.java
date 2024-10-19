package com.shuklansh.springInitProj.runners.run.local;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/greet")
public class RunGreetingsController {
    @GetMapping("")
    String greetUser() {
        return "hello runner!";
    }
}
