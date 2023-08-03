package com.HUBOT.HUBOT.Course;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepositry extends MongoRepository<Course,String> {
    Course findByCourseNumber(int courseNumber);
    List<Course> findCourseByDepartmentDepartmentId(String departmentName);

    Course deleteByCourseNumber(int courseNumber);
}
