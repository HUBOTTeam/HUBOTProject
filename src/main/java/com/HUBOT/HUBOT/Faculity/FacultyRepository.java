package com.HUBOT.HUBOT.Faculity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends MongoRepository<Faculty,String> {
    Faculty findByFacultyName(String facultyName);

    void deleteByFacultyName(String facultyName);
}