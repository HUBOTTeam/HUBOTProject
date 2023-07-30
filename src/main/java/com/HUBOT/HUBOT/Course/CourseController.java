package com.HUBOT.HUBOT.Course;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/course/")
public class CourseController {

    private CourseServices courseServices;

    @PostMapping(value = "addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        Course addedCourse = courseServices.addCourse(course);

        if (addedCourse != null) {
            String responseMessage = "Course added successfully!";
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        } else {
            String errorMessage = "Course addition failed!";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

}
