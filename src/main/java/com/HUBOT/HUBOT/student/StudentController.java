package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    StudentServices studentServices;
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }

    @GetMapping("/getStudent")
    public Optional<Student> getStudent(@RequestParam String Id){
        return studentServices.getStudent(Id);
    }

    @PostMapping("/createStudent")
    public String addStudent(@RequestParam Student student){
        return studentServices.addStudent(student);
    }

    @PutMapping("updateStudentName")
    public String updateStudentName(@RequestParam Student student){
        return studentServices.updateStudentName(student);
    }

    @DeleteMapping("/deleteStudent")
    public String deleteStudent(@RequestParam String id){
        return studentServices.deleteStudent(id);
    }


}
