package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/faculity/")
public class FaculityController {

    private FaculityServices faculityServices;

    @PostMapping(value = "addFaculity")
    public String addFaculity(@RequestBody Faculity faculity){
        return faculityServices.addFaculity(faculity);
    }

    @GetMapping(value = "getAllFaculties")
    public List<Faculity> getAllFaculties(){
        return faculityServices.getAllFaculties();
    }

    @PutMapping(value = "updateFacultyKeyword")
    public String updateFacultyKeyword(@RequestParam String faculityName , @RequestParam String keyword){
        return faculityServices.updateFacultyKeyword(faculityName,keyword);
    }

    @DeleteMapping(value = "deleteFaculty")
    public String deleteFaculty(@RequestParam String faculityName){
        return faculityServices.deleteFaculty(faculityName);
    }

}