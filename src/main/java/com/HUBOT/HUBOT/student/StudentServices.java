package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@AllArgsConstructor
@Service
public class StudentServices {

    StudentRepository studentRepository;

    public String addStudent(Student student) {
        try {
      studentRepository.insert(student);
      return " ";
        }catch (Exception e){
            return null;
        }
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student getStudentByUserId(String id) {
        return studentRepository.findByUserId(id);
    }

    public Student getStudentByUserName(String id) {
        return studentRepository.findByUserUserName(id);
    }

    public List<Student> getStudentsByDepartmentId(String departmentId) {
        return studentRepository.findByDepartmentDepartmentId(departmentId);
    }

    public Student updateStudentFirstName(String id , String firstName,
                                           String middleName, String LastName) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null){
            student.setFirstName(firstName);
            student.setMiddleName(middleName);
            student.setLastName(LastName);
            return studentRepository.save(student);
        }
        return null;
    }


    public Boolean deleteStudent(String userName) {
        Student student = studentRepository.findByUserUserName(userName);
        studentRepository.deleteById(userName);
        return true;
    }


    public String getFirstNameAndLastName(String userId) {
        try {
            Student student = studentRepository.findByUserId(userId);
            if (student != null)
            return student.getFirstName() +" "+ student.getLastName();
            else
                return null;
        }catch (Exception e){
            return null;
        }
    }

    public String getGender(String userId) {
        try {
            Student student = studentRepository.findByUserId(userId);
            if (student != null)
                return student.getGender().toString().toLowerCase();
            else
                return null;
        }catch (Exception e){
            return null;
        }
    }
}