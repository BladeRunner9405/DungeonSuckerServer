package com.mipt.DungeonSuckerServer.services;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.mipt.DungeonSuckerServer.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    // private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
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

    public void registerUser(UserEntity user) {
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public static boolean compareUserPassword(String login, String tryPassword) {
        return true;
    }
}

