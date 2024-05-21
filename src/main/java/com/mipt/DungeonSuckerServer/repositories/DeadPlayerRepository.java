package com.mipt.DungeonSuckerServer.repositories;

import com.mipt.DungeonSuckerServer.entities.DeadPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeadPlayerRepository extends JpaRepository<DeadPlayerEntity, Integer> {
}
