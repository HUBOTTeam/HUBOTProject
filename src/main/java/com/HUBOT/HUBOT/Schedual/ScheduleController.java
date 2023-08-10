package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/createSchedule")
    public ResponseEntity<Schedule> createSchedule(@RequestParam String studentId,
                                                   @RequestParam int semester,
                                                   @RequestParam int year) {
        Schedule createdSchedule = scheduleService.createSchedule(studentId, semester, year);
        if (createdSchedule != null) {
            return new ResponseEntity<>(createdSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addCourseToSchedule")
    public ResponseEntity<Schedule> addCourseToSchedule(@RequestParam String scheduleId,
                                                        @RequestBody Course course) {
        Schedule updatedSchedule = scheduleService.addCourseToSchedule(scheduleId, course);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getScheduleByStudentId")
    public ResponseEntity<Schedule> getScheduleByStudentId(@RequestParam String studentId,
                                                           @RequestParam int semester,
                                                           @RequestParam int year) {
        Schedule schedule = scheduleService.getScheduleByStudentId(studentId, semester, year);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/removeSubject")
    public ResponseEntity<Schedule> removeSubjectFromSchedule(@RequestParam String studentId, @RequestBody Course course) {
        Schedule updatedSchedule = scheduleService.removeSubjectFromSchedule(studentId, course);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateSemesterAndYear")
    public ResponseEntity<Schedule> updateSemesterAndYear(@RequestParam String studentId, @RequestParam int semester, @RequestParam int year) {
        Schedule updatedSchedule = scheduleService.updateSemesterAndYear(studentId, semester, year);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/transferCoursesToTakenCourses")
    public ResponseEntity<Schedule> transferCoursesToTakenCourses(@RequestParam String studentId,
                                                                  @RequestParam int semester,
                                                                  @RequestParam int year,
                                                                  @RequestParam double grade) {
        Schedule updatedSchedule = scheduleService.transferCoursesToTakenCourses(studentId, semester, year, grade);
        if (updatedSchedule != null) {
            return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
