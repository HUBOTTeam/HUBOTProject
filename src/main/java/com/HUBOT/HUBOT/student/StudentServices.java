package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {

//    @Autowired
//    Student std;
    @Autowired
    StudentRepositry studentRepositry;

    public List<Student> getAllStudents() {
        return studentRepositry.findAll();
    }

    public Optional<Student> getStudent(String Id) {
        return studentRepositry.findById(Id);
    }

    public String addStudent(Student student) {
        studentRepositry.insert(student);
        return "Student added successfully";
    }

    public String updateStudentName(Student student) {
        if (studentRepositry.findById(student.getId()).isEmpty()) {
            System.out.println("There is no student with this id");
        } else {
            studentRepositry.save(student);
            System.out.println("Student name updated sucessfully!!");
        }
        return null;
    }

    public String deleteStudent(String Id) {
        studentRepositry.deleteById(Id);
        return "Student with this id "+ Id+" is removed successfully!!";
    }
}
