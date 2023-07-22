package com.HUBOT.HUBOT.student;

import com.HUBOT.HUBOT.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/student")
    public List<Student> getStudent(){
        return List.of(new Student(
                1L,
                "mariam",
                LocalDate.of(2000, Month.APRIL,29),
                21,
                "mo@gmail.com"
        ));
    }
}
