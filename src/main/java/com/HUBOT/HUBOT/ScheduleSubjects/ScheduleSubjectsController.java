package com.HUBOT.HUBOT.ScheduleSubjects;


import com.HUBOT.HUBOT.DeletionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ScheduleSubjects")
public class ScheduleSubjectsController {

    private final ScheduleSubjectsService scheduleSubjectsService;

    @Autowired
    public ScheduleSubjectsController(ScheduleSubjectsService scheduleSubjectsService) {
        this.scheduleSubjectsService = scheduleSubjectsService;
    }

    @PostMapping("/addSubject")
    public ResponseEntity<ScheduleSubjects> addSubject(@RequestBody ScheduleSubjects scheduleSubjects) {
        ScheduleSubjects addSubject = scheduleSubjectsService.addSubject(scheduleSubjects);
        if (addSubject != null) {
            return new ResponseEntity<>(addSubject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("getSubjectForStudent")
    public ResponseEntity<List<ScheduleSubjects>> getSubjectsForStudent(@RequestParam String studentId){
        List<ScheduleSubjects> scheduleSubjects = scheduleSubjectsService.getSubjectsForStudent(studentId);
        if (scheduleSubjects != null) {
            return new ResponseEntity<>(scheduleSubjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("getSpecificSubjectForStudent")
    public ResponseEntity<ScheduleSubjects> getSpecificSubjectForStudent(@RequestParam String studentId, @RequestParam String courseId){
        ScheduleSubjects scheduleSubjects = scheduleSubjectsService.getSpecificSubjectForStudent(studentId,courseId);
        if (scheduleSubjects != null) {
            return new ResponseEntity<>(scheduleSubjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/removeSubject")
    public ResponseEntity<DeletionResponse> removeSubject(@RequestParam String courseId, @RequestParam String studentId) {
        DeletionResponse deletionResponse = scheduleSubjectsService.removeSubject(courseId, studentId);
        if (deletionResponse.isSuccess()) {
            return new ResponseEntity<>(deletionResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(deletionResponse, HttpStatus.NOT_FOUND);
        }
    }
}


