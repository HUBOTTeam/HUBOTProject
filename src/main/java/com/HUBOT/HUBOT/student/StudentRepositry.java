package com.HUBOT.HUBOT.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositry extends MongoRepository<Student,String> {

}