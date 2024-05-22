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
        String stub = "[[6],[0,1,1,1,1],[0,5,0,0,0,0,0,0,25,5]]";
        DeadPlayerEntity deadPlayer = DeadPlayerService.getRandom();
        return deadPlayer == null ? stub : deadPlayer.getData();
    }
}
