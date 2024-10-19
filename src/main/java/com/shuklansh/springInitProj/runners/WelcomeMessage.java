package com.shuklansh.springInitProj.runners;

import org.springframework.stereotype.Component;

import static java.sql.DriverManager.println;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage(String name) {
        String myStr = "Hello %s! welcome to my first spring project";
        return String.format(myStr, name);
    }
}
