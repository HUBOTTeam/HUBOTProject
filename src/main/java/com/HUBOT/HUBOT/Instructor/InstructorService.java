package com.HUBOT.HUBOT.Instructor;

import com.HUBOT.HUBOT.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor getInstructorById(String instructorId) {
        return instructorRepository.findById(instructorId).orElse(null);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public List<Instructor> getInstructorsByName(String firstName, String lastName) {
        return instructorRepository.findByInstructorFirstNameAndInstructorLastName(firstName, lastName);
    }

    public List<Instructor> getInstructorsByDepartment(Department department) {
        return instructorRepository.findInstructorByDepartment(department);
    }

    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public boolean deleteInstructor(String instructorId) {
        Instructor existingInstructor = instructorRepository.findById(instructorId).orElse(null);
        if (existingInstructor != null) {
            instructorRepository.delete(existingInstructor);
            return true;
        }
        return false;
    }
}
