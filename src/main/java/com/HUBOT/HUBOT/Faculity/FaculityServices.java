package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FaculityServices {

    private FaculityRepositry faculityRepositry;

    public String addFaculity(Faculity faculity) {
        faculityRepositry.insert(faculity);
        return faculity.getFaculityName()+" added successfully!!";
    }

    public List<Faculity> getAllFaculties() {
        return faculityRepositry.findAll();
    }

    public String updateFacultyKeyword(String faculityName, String keyword) {
        Faculity faculity = faculityRepositry.findByfaculityName(faculityName);
        faculity.setKeyword(keyword);
        faculityRepositry.save(faculity);
        return faculityName+" updated successfully!!";
    }

    public String deleteFaculty(String faculityName) {
        faculityRepositry.deleteByfaculityName(faculityName);
        return faculityName+" deleted successfully!";
    }
}