package com.HUBOT.HUBOT.TakenCourses;

import com.HUBOT.HUBOT.Course.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakenCoursesRepository extends MongoRepository<TakenCourses, String> {
        TakenCourses findByCourseCourseNumber(long courseNumber);
        List<TakenCourses> findByStudentId(String studentId);
}
