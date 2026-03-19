package com.hackerrank.stereotypes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // Represents a database connection → generic bean
    @Component
    public static class DatabaseConnection {

    }

    // Represents a simple message object → generic bean
    @Component
    public static class Message {

    }
}