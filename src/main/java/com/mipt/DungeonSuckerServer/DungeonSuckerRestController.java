package com.mipt.DungeonSuckerServer;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import com.mipt.DungeonSuckerServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DungeonSuckerRestController {
    @Autowired
    private UserService userService;

    @PostMapping({"/api/sendDeadPlayerData", "/office/sendDeadPlayerData"})
    public String sendJSON(@RequestBody String json) {
        DeadPlayerDataHandler.saveDeadPlayerData(json);
        return "JSON received: " + json;
    }

    @GetMapping({"/api/receiveDeadPlayerData", "/office/receiveDeadPlayerData"})
    public String receiveJSON() {
        return DeadPlayerDataHandler.getRandomDeadPlayerData();
    }


    @GetMapping("/office/myOffice")
    public String myOffice() {
        return "You are in my office!";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody String login, String password) {
        UserEntity user = new UserEntity();
        user.setEmail(login);
        user.setPassword(password);

        userService.registerUser(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

}