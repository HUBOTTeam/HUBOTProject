package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServices {

    StudentRepositry studentRepositry;

    public List<Student> getAllStudents() {
        return studentRepositry.findAll();
    }
    public String addStudent(Student student) {
        studentRepositry.insert(student);
        return "Student added successfully";
    }

    public Student getStudentById(String id) {
        return studentRepositry.findById(id).get();
    }

    public Student getStudentByUserId(String id) {
        return studentRepositry.findByUserId(id);
    }

    public List<Student> getStudentsByDepartmentId(String departmentId) {
        return studentRepositry.findByDepartmentDepartmentId(departmentId);
    }

    public Student updateStudentName(String id ,String name) {
        Student student = studentRepositry.findById(id).get();
        if (student != null){
            student.setName(name);
            return studentRepositry.save(student);
        }
        return null;
    }


    public Boolean deleteStudent(String id) {
        Student student = studentRepositry.findById(id).get();
        if (student != null){
            studentRepositry.deleteById(id);
            return true;}
        return false;
    }
}