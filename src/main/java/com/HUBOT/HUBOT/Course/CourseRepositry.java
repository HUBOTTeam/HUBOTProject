package com.HUBOT.HUBOT.Course;

import com.HUBOT.HUBOT.Enum.CourseType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepositry extends MongoRepository<Course,String> {
    Course findByCourseNumber(int courseNumber);
    List<Course> findCourseByDepartmentDepartmentId(String departmentName);
   // List<Course> fineCourseByCourseTypAndDepartment(CourseType courseType,String departmentId);

    Course deleteByCourseNumber(int courseNumber);
}
