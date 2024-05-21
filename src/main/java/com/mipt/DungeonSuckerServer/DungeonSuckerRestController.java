package com.mipt.DungeonSuckerServer;

import com.mipt.DungeonSuckerServer.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DungeonSuckerRestController {
    private int savedNumber = 0;
    @PostMapping("/api/test")
    public ResponseEntity<String> processNumber(@RequestBody int number) {
        savedNumber = number;
        return ResponseEntity.ok("Number processed: " + number);
    }
    @GetMapping("/home")
    public String goHome() {
        return "Hello, user!";
    }

    @GetMapping("/api/test")
    public String getProcessedNumber() {
        return "Saved number: " + savedNumber;
    }

    @GetMapping("/api/home")
    public String apiHomeEndpoint() {
        System.out.println("Hello there!");
        return "Welcome to the api home!";
    }
}