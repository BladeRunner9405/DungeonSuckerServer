package com.mipt.DungeonSuckerServer.services;

import com.mipt.DungeonSuckerServer.RandomNumGenerator;
import com.mipt.DungeonSuckerServer.entities.DeadPlayerEntity;
import com.mipt.DungeonSuckerServer.entities.UserEntity;
import com.mipt.DungeonSuckerServer.repositories.DeadPlayerRepository;
import com.mipt.DungeonSuckerServer.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class DeadPlayerService {
    private static DeadPlayerRepository deadPlayerRepository;

    public DeadPlayerService(DeadPlayerRepository deadPlayerRepository){
        this.deadPlayerRepository = deadPlayerRepository;
    }

    public static void save(DeadPlayerEntity deadPlayerEntity) {
        deadPlayerRepository.save(deadPlayerEntity);
    }

    public static DeadPlayerEntity getRandom() {
        if(deadPlayerRepository.count() == 0) return null;
        int randomRowNumber = RandomNumGenerator.generateFromRange(1, (int) deadPlayerRepository.count());
        return deadPlayerRepository.findById(randomRowNumber).get();
    }
}
