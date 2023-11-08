package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/student/")
public class StudentController {

    private StudentServices studentServices;
    @PostMapping("/createStudent")
    public String addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentServices.getAllStudents();
    }

    @GetMapping("/getStudentById")
    public ResponseEntity<Student> getStudentById(@RequestParam String id){
        Student student = studentServices.getStudentById(id);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentByUserId")
    public ResponseEntity<Student> getStudentByUserId(@RequestParam String id){
        Student student = studentServices.getStudentByUserId(id);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(student,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentsByDepartmentId")
    public ResponseEntity<List<Student>> getStudentsByDepartmentId(@RequestParam String departmentId){
        List<Student> students = studentServices.getStudentsByDepartmentId(departmentId);
        if (students != null)
            return new ResponseEntity<>(students,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateStudentName")
    public ResponseEntity<Student> updateStudentName(@RequestParam String id ,@RequestParam String name){
        Student student = studentServices.updateStudentName(id,name);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Void> deleteStudent(@RequestParam String id){
        Boolean student = studentServices.deleteStudent(id);
        if(student != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}