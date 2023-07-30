package com.HUBOT.HUBOT.Instructor;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepositry extends MongoRepository<Instructor,String> {
}
