package com.HUBOT.HUBOT.Faculity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FacultyServices {

    private FacultyRepository facultyRepository;

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.insert(faculty);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }
    public Faculty getFacultyById(String facultyId) {
        return facultyRepository.findById(facultyId).orElse(null);
    }

    public Faculty getFacultyByName(String facultyName) {
        return facultyRepository.findByFacultyName(facultyName);
    }


    public String updateFacultyKeyword(String facultyName, String keyword) {
        Faculty faculty = facultyRepository.findByFacultyName(facultyName);
        if (faculty != null) {
            faculty.setKeyword(keyword);
            facultyRepository.save(faculty);
            return facultyName + " updated successfully!!";
        } else {
            return "Faculty with name: " + facultyName + " not found";
        }
    }

    public String updateFacultyDescription(String facultyName, String description) {
        Faculty faculty = facultyRepository.findByFacultyName(facultyName);
        if (faculty != null) {
            faculty.setDescription(description);
            facultyRepository.save(faculty);
            return facultyName + " updated successfully!!";
        } else {
            return "Faculty with name: " + facultyName + " not found";
        }
    }

    public String updateFacultyFloor(String facultyName, int floor) {
        Faculty faculty = facultyRepository.findByFacultyName(facultyName);
        if (faculty != null) {
            faculty.setFloor(floor);
            facultyRepository.save(faculty);
            return facultyName + " updated successfully!!";
        } else {
            return "Faculty with name: " + facultyName + " not found";
        }
    }

    public String deleteFaculty(String facultyName) {
        Faculty faculty = facultyRepository.findByFacultyName(facultyName);
        if (faculty != null) {
            facultyRepository.delete(faculty);
            return facultyName + " deleted successfully!";
        } else {
            return "Faculty with name: " + facultyName + " not found";
        }
    }
}
