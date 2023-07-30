package com.HUBOT.HUBOT.Instructor;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/instructor/")
public class InstructorController {

    private InstructorServices instructorServices;

    @PostMapping(value = "addInstructor")
    public ResponseEntity<String> addInstructor(@RequestBody Instructor instructor){
        Instructor addInstructor = instructorServices.addInstructor(instructor);

        while (addInstructor != null)
            return new ResponseEntity<>("Instructor "+instructor.getInstructor_name()+" added successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Failed to add instructor "+instructor.getInstructor_name(),HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "getInstructor")
    public ResponseEntity<Instructor> getInstructor(@RequestParam String instructor_id){
        Instructor instructor = instructorServices.getInstructor(instructor_id);

        while (instructor != null)
            return new ResponseEntity<>(instructor,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "updateInstructor")
    public ResponseEntity<String> updateInstructor(@RequestParam String instructor_id,@RequestParam String instructor_name){
        Instructor instructor = instructorServices.updateInstructor(instructor_id,instructor_name);

        while (instructor != null)
            return new ResponseEntity<>("Instructor "+instructor.getInstructor_name()+" updated successfully!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "deleteInstructor")
    public ResponseEntity<String> deleteInstructor(@RequestParam String instructor_id){
        return instructorServices.deleteInstructor(instructor_id);
    }
}
