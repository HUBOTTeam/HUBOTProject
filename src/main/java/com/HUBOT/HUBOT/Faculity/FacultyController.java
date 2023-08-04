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

    @GetMapping(value = "getAllFaculties")
    public List<Faculty> getAllFaculties(){
        return facultyServices.getAllFaculties();
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
    public ResponseEntity<String> updateFacultyKeyword(@RequestParam String facultyName, @RequestParam String keyword){
        String result = facultyServices.updateFacultyKeyword(facultyName, keyword);
        if (result.equals("Faculty with name: " + facultyName + " not found")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "updateFacultyDescription")
    public ResponseEntity<String> updateFacultyDescription(@RequestParam String facultyName, @RequestParam String description){
        String result = facultyServices.updateFacultyDescription(facultyName, description);
        if (result.equals("Faculty with name: " + facultyName + " not found")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PutMapping(value = "updateFacultyFloor")
    public ResponseEntity<String> updateFacultyFloor(@RequestParam String facultyName, @RequestParam int floor){
        String result = facultyServices.updateFacultyFloor(facultyName, floor);
        if (result.equals("Faculty with name: " + facultyName + " not found")) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "deleteFaculty")
    public ResponseEntity<String> deleteFaculty(@RequestParam String facultyName){
        String result = facultyServices.deleteFaculty(facultyName);
        if (result.endsWith(" deleted successfully!")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
