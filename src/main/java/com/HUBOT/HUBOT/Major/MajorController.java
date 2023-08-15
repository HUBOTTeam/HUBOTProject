package com.HUBOT.HUBOT.Major;

import com.HUBOT.HUBOT.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {

    private final MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @PostMapping("/addMajor")
    public ResponseEntity<Major> addMajor(@RequestBody Major major) {
        Major addedMajor = majorService.addMajor(major);
        return new ResponseEntity<>(addedMajor, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMajor")
    public ResponseEntity<String> deleteMajor(@RequestParam String majorId) {
        boolean deleted = majorService.deleteMajor(majorId);
        if (deleted) {
            return new ResponseEntity<>("Major with ID: " + majorId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Major with ID: " + majorId + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getMajorByName")
    public ResponseEntity<Major> getMajorByName(@RequestParam String majorName) {
        Major major = majorService.getMajorByName(majorName);
        if (major != null) {
            return new ResponseEntity<>(major, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMajorByDepartment")
    public ResponseEntity<List<Major>> getAllMajorByDepartment(@RequestBody Department department) {
        List<Major> majors = majorService.getAllMajorByDepartment(department);
        if (!majors.isEmpty()) {
            return new ResponseEntity<>(majors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllMajor")
    public ResponseEntity<List<Major>> getAllMajor() {
        List<Major> majors = majorService.getAllMajor();
        if (!majors.isEmpty()) {
            return new ResponseEntity<>(majors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add more endpoints for other operations...
}
