package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FaculityServices {

    private FaculityRepositry faculityRepositry;

    public String addFaculity(Faculity faculity) {
        faculityRepositry.insert(faculity);
        return faculity.getFaculityName()+" added successfully!!";
    }
}
