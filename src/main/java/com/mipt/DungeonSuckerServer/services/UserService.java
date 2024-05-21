package com.mipt.DungeonSuckerServer.services;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.mipt.DungeonSuckerServer.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }

    public UserEntity findByUUID(String uuid)
    {
        UserEntity example = new UserEntity();
        example.setUuid(uuid);
        return userRepository.findOne(Example.of(example)).get();
    }

    public UserEntity findByName(String name)
    {
        UserEntity example = new UserEntity();
        example.setName(name);
        return userRepository.findOne(Example.of(example)).get();
    }
}
