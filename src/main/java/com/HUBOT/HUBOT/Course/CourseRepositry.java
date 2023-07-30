package com.HUBOT.HUBOT.Course;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositry extends MongoRepository<Course,String> {
    Course findBycourseNumber(int courseNumber);

    Course deleteBycourseNumber(int courseNumber);
}
