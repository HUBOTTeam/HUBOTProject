package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/student/")
public class StudentController {

    private StudentServices studentServices;
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }
    @PostMapping("/createStudent")
    public String addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }

//    @PutMapping("updateStudentName")
//    public String updateStudentName(@RequestParam Student student){
//        return studentServices.updateStudentName(student);
//    }

//    @DeleteMapping("/deleteStudent")
//    public String deleteStudent(@RequestParam String id){
//        return studentServices.deleteStudent(id);
//    }
//

}