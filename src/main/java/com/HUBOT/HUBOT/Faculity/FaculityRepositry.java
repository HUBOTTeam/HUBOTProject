package com.HUBOT.HUBOT.Faculity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaculityRepositry extends MongoRepository<Faculity,String> {
    Faculity findByfaculityName(String faculityName);

    void deleteByfaculityName(String faculityName);
}