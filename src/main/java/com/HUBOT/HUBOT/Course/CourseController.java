package com.HUBOT.HUBOT.Course;

import com.HUBOT.HUBOT.Enum.CourseType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/course/")
public class CourseController {

    private CourseServices courseServices;

    @PostMapping(value = "addCourse")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course addedCourse = courseServices.addCourse(course);
        if (addedCourse != null) {
            return new ResponseEntity<>(course,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> courses = courseServices.getAllCourses();
        if (!courses.isEmpty())
            return new ResponseEntity<>(courses,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("getCourseById")
    public ResponseEntity<Course> getCourseByCourseId(@RequestParam String courseId){
        Course course = courseServices.getCourseByCourseId(courseId);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getCourseByCourseNumber")
    public ResponseEntity<Course> getCourseByCourseNumber(@RequestParam int courseNumber){
        Course course = courseServices.getCourseByCourseNumber(courseNumber);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("getCourseIdByCourseName")
    public ResponseEntity<Map<String, String>> getCourseIdByCourseName(@RequestParam String courseName){
        String courseId = courseServices.getCourseIdByCourseName(courseName);
        if (courseId != null) {
            Map<String, String> response = new HashMap<>();
            response.put("id", courseId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "getAllCoursesInDepartment")
    public ResponseEntity<List<Course>> getAllCoursesInDepartment(@RequestParam String departmentId){
        List<Course> course = courseServices.getAllCoursesInDepartment(departmentId);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "updateCourseName")
    public ResponseEntity<Course> updateCourseName(@RequestParam int courseNumber , @RequestParam String courseName){
        Course course = courseServices.updateCourseName(courseNumber,courseName);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "updateCourseNumber")
    public ResponseEntity<Course> updateCourseNumber(@RequestParam int courseNumber,@RequestParam int courseNewNumber){
        Course course = courseServices.updateCourseNumber(courseNumber,courseNewNumber);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "updateCourseKeyword")
    public ResponseEntity<Course> updateCourseKeyword(@RequestParam int courseNumber,@RequestParam String newKeyword){
        Course course = courseServices.updateCourseKeyword(courseNumber,newKeyword);
        if (course != null)
            return new ResponseEntity<>(course,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("updateCourseDescription")
    public ResponseEntity<Course> updateCourseDescription(@RequestParam int courseNumber, @RequestParam String description) {
        Course course = courseServices.updateCourseDescription(courseNumber, description);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updatePointsOfDifficulty")
    public ResponseEntity<Course> updatePointsOfDifficulty(@RequestParam int courseNumber, @RequestParam int pointsOfDifficulty) {
        Course course = courseServices.updatePointsOfDifficulty(courseNumber, pointsOfDifficulty);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateCreditHours")
    public ResponseEntity<Course> updateCreditHours(@RequestParam int courseNumber, @RequestParam int creditHours) {
        Course course = courseServices.updateCreditHours(courseNumber, creditHours);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "deleteCourse")
    public ResponseEntity<Course> deleteCourse(@RequestParam int courseNumber){
        Course course = courseServices.deleteCourse(courseNumber);
        if(course != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
