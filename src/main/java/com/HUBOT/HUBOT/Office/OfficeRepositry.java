package com.HUBOT.HUBOT.Office;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepositry extends MongoRepository<Office,String> {
}
