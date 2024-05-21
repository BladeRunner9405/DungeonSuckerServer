package com.mipt.DungeonSuckerServer;

import com.mipt.DungeonSuckerServer.entities.DeadPlayerEntity;
import com.mipt.DungeonSuckerServer.services.DeadPlayerService;

public class DeadPlayerDataHandler {
    public static void saveDeadPlayerData(String json) {
        DeadPlayerEntity deadPlayer = new DeadPlayerEntity();
        deadPlayer.setData(json);
        DeadPlayerService.save(deadPlayer);
    }

    public static String getRandomDeadPlayerData() {
        DeadPlayerEntity deadPlayer = DeadPlayerService.getRandom();
        return deadPlayer == null ? null : deadPlayer.getData();
    }
}
