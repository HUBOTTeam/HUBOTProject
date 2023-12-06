package com.HUBOT.HUBOT.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/registerStudent")
public class StudentController {

    private StudentServices studentServices;
    @PostMapping("/createStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        if (studentServices.addStudent(student) != null){
            return new ResponseEntity<>("Student added successfully",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentByUserId")
    public ResponseEntity<Student> getStudentByUserId(@RequestParam String id){
        Student student = studentServices.getStudentByUserId(id);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentByUserName")
    public ResponseEntity<Student> getStudentByUserName(@RequestParam String userName){
        Student student = studentServices.getStudentByUserName(userName);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getName")
    public ResponseEntity<String> getFirstNameAndLastName(String userId){
        String name = studentServices.getFirstNameAndLastName(userId);
        if (name != null)
            return new ResponseEntity<>(name,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/getGender")
    public ResponseEntity<String> getGender(String userId) {
        String gender = studentServices.getGender(userId);
        if (gender != null)
            return new ResponseEntity<>(gender,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getStudentsByDepartmentId")
    public ResponseEntity<List<Student>> getStudentsByDepartmentId(@RequestParam String departmentId){
        List<Student> students = studentServices.getStudentsByDepartmentId(departmentId);
        if (students != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateStudentName")
    public ResponseEntity<Student> updateStudentName(@RequestParam String id ,@RequestParam String firstName,
                                                     @RequestParam String middleName, @RequestParam String LastName){
        Student student = studentServices.updateStudentFirstName(id,firstName,middleName,LastName);
        if (student != null)
            return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<Void> deleteStudent(@RequestParam String userName){
        Boolean student = studentServices.deleteStudent(userName);
        if(student != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}