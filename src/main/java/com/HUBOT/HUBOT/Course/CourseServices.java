package com.HUBOT.HUBOT.Course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServices {

    private CourseRepositry courseRepositry;

    public Course addCourse(Course course) {
            return courseRepositry.insert(course);
    }
}
