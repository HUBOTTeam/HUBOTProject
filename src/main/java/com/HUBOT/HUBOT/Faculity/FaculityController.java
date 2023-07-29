package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/faculity/")
public class FaculityController {

    private FaculityServices faculityServices;

    @PostMapping(value = "addFaculity")
    public String addFaculity(@RequestBody Faculity faculity){
        return faculityServices.addFaculity(faculity);
    }
}
