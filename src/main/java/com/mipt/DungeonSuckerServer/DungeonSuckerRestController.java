package com.mipt.DungeonSuckerServer;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import com.mipt.DungeonSuckerServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> registerUser(@RequestHeader String login, @RequestHeader String password) {
        UserEntity user = new UserEntity();

        if (login == null || password == null) {
            return ResponseEntity.ok("Не введён логин или пароль");
        }
        user.setName(login);
        user.setPassword(password);
        userService.save(user);

        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

}