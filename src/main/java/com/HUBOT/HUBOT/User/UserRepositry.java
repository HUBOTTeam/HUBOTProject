package com.HUBOT.HUBOT.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends MongoRepository<User,String> {
    User findByUserName(String userName);
}
