package com.HUBOT.HUBOT.Instructor;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InstructorServices {

    private InstructorRepositry instructorRepositry;

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepositry.insert(instructor);
    }

    public Instructor getInstructor(String instructorId) {
        return instructorRepositry.findById(instructorId).orElse(null);
    }

    public Instructor updateInstructor(String instructorId, String instructorName) {
        Instructor instructor = instructorRepositry.findById(instructorId).orElse(null);
        instructor.setInstructor_name(instructorName);
        return instructorRepositry.save(instructor);
    }

    public ResponseEntity<String> deleteInstructor(String instructorId) {
        if (instructorRepositry.existsById(instructorId)) {
            instructorRepositry.deleteById(instructorId);
            return new ResponseEntity<>("Instructor deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Deletion Error!!",HttpStatus.NOT_FOUND);
    }
    }

