package com.mipt.DungeonSuckerServer.services;

import com.mipt.DungeonSuckerServer.entities.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.mipt.DungeonSuckerServer.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    public UserEntity findByUUID(String uuid) {
        UserEntity example = new UserEntity();
        example.setUuid(uuid);
        return userRepository.findOne(Example.of(example)).get();
    }

    public UserEntity findByName(String name) {
        UserEntity example = new UserEntity();
        example.setName(name);
        Optional<UserEntity> optionalUserEntity = userRepository.findOne(Example.of(example));
        return optionalUserEntity.orElse(null);
    }

    public boolean compareUserPassword(String login, String tryPassword) {
        UserEntity user = findByName(login);
        return user.getPassword().equals(tryPassword);
    }
}

