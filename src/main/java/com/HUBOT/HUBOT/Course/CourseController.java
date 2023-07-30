package com.HUBOT.HUBOT.Course;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseServices.getAllCourses();

        if (!courses.isEmpty())
            return new ResponseEntity<>(courses,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getCourse")
    public ResponseEntity<Course> getCourseBycourseNumber(@RequestParam int courseNumber){
        Course course = courseServices.getCourseBycourseNumber(courseNumber);

        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "updateCourseKeyword")
    public ResponseEntity<String> updateCourseName(@RequestParam int courseNumber , @RequestParam String keyword){
        Course course = courseServices.updateCourseName(courseNumber,keyword);

        if (course != null)
            return new ResponseEntity<>(courseNumber+" updated successfully!",HttpStatus.OK);
        return new ResponseEntity<>("Failed to updated !",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "deleteCourse")
    public ResponseEntity<String> deleteCourse(@RequestParam int courseNumber){
        Course course = courseServices.deleteCourse(courseNumber);

        if(course != null)
            return new ResponseEntity<>(courseNumber+" deleted successfully!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
