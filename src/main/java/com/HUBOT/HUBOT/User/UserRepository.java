package com.HUBOT.HUBOT.User;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    @NotNull
    Optional<User> findById(String id);
    User findByUserName(String userName);
}