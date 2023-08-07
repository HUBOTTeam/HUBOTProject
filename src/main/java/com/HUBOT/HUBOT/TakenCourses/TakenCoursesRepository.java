package com.HUBOT.HUBOT.TakenCourses;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakenCoursesRepository extends MongoRepository<TakenCourses, String> {
    // Add any custom query methods here if needed
}
