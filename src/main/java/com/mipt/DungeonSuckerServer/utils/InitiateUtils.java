package com.mipt.DungeonSuckerServer.utils;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import com.mipt.DungeonSuckerServer.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitiateUtils implements CommandLineRunner {
    public final UserService userService;

    public InitiateUtils(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUuid("w523sc4ge2ac3512ge4");
        userEntity.setName("silly-erp");
        userEntity.setPassword("42");
        userEntity.setEmail("vanya.kalinin@kloun.ru");
        userService.save(userEntity);
    }
}
