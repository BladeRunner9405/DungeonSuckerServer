package com.mipt.DungeonSuckerServer.repositories;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
