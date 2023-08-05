package com.HUBOT.HUBOT.Instructor;

import com.HUBOT.HUBOT.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/addInstructor")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor addedInstructor = instructorService.addInstructor(instructor);
        if (addedInstructor != null) {
            return new ResponseEntity<>(addedInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getInstructorById")
    public ResponseEntity<Instructor> getInstructorById(@RequestParam String instructorId) {
        Instructor instructor = instructorService.getInstructorById(instructorId);
        if (instructor != null) {
            return new ResponseEntity<>(instructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllInstructors")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        if (!instructors.isEmpty()) {
            return new ResponseEntity<>(instructors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getInstructorsByName")
    public ResponseEntity<List<Instructor>> getInstructorsByName(
            @RequestParam String firstName,
            @RequestParam String lastName) {
        List<Instructor> instructors = instructorService.getInstructorsByName(firstName, lastName);
        if (!instructors.isEmpty()) {
            return new ResponseEntity<>(instructors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getInstructorsByGender")
    public ResponseEntity<List<Instructor>> getInstructorsByGender(@RequestParam Gender gender) {
        List<Instructor> instructors = instructorService.getInstructorsByGender(gender);
        if (!instructors.isEmpty()) {
            return new ResponseEntity<>(instructors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateInstructor")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(instructor);
        if (updatedInstructor != null) {
            return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteInstructor")
    public ResponseEntity<String> deleteInstructor(@RequestParam String instructorId) {
        boolean deleted = instructorService.deleteInstructor(instructorId);
        if (deleted) {
            return new ResponseEntity<>("Instructor with ID: " + instructorId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Instructor with ID: " + instructorId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
