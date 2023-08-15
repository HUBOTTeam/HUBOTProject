package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/faculty/")
public class FacultyController {

    private FacultyServices facultyServices;

    @PostMapping(value = "addFaculty")
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyServices.addFaculty(faculty);
    }

    @GetMapping(value = "getFacultyById")
    public ResponseEntity<Faculty> getFacultyById(@RequestParam String facultyId){
        Faculty faculty = facultyServices.getFacultyById(facultyId);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "getAllFaculties")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        List<Faculty> faculties = facultyServices.getAllFaculties();
        return new ResponseEntity<>(faculties, HttpStatus.OK);
    }
    @GetMapping(value = "getFacultyByName")
    public ResponseEntity<Faculty> getFacultyByName(@RequestParam String facultyName){
        Faculty faculty = facultyServices.getFacultyByName(facultyName);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "updateFacultyKeyword")
    public ResponseEntity<Faculty> updateFacultyKeyword(@RequestParam String facultyName, @RequestParam String keyword){
        Faculty faculty = facultyServices.updateFacultyKeyword(facultyName, keyword);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "updateFacultyDescription")
    public ResponseEntity<Faculty> updateFacultyDescription(@RequestParam String facultyName, @RequestParam String description){
        Faculty faculty = facultyServices.updateFacultyDescription(facultyName, description);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "updateFacultyFloor")
    public ResponseEntity<Faculty> updateFacultyFloor(@RequestParam String facultyName, @RequestParam int floor){
        Faculty faculty = facultyServices.updateFacultyFloor(facultyName, floor);
        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "deleteFaculty")
    public void deleteFaculty(@RequestParam String facultyName) {
        facultyServices.deleteFaculty(facultyName);
    }
}
