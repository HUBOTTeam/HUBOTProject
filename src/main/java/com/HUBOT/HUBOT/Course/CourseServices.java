package com.HUBOT.HUBOT.Course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServices {

    private CourseRepositry courseRepositry;

    public Course addCourse(Course course) {
            return courseRepositry.insert(course);
    }

    public List<Course> getAllCourses() {
        return courseRepositry.findAll();
    }

    public Course getCourseBycourseNumber(int courseNumber) {
        return courseRepositry.findBycourseNumber(courseNumber);
    }

    public Course updateCourseName(int courseNumber, String keyword) {
        Course course = courseRepositry.findBycourseNumber(courseNumber);
        course.setKeyword(keyword);
        return courseRepositry.save(course);
    }

    public Course deleteCourse(int courseNumber) {
        return courseRepositry.deleteBycourseNumber(courseNumber);
    }
}
