package com.HUBOT.HUBOT.TakenCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taken-courses")
public class TakenCoursesController {

    private final TakenCoursesService takenCoursesService;

    @Autowired
    public TakenCoursesController(TakenCoursesService takenCoursesService) {
        this.takenCoursesService = takenCoursesService;
    }

    @PostMapping("/addTakenCourse")
    public ResponseEntity<TakenCourses> addTakenCourse(@RequestBody TakenCourses takenCourse) {
        TakenCourses addedTakenCourse = takenCoursesService.addTakenCourse(takenCourse);
        if (addedTakenCourse != null) {
            return new ResponseEntity<>(addedTakenCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
