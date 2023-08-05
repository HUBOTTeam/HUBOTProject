package com.HUBOT.HUBOT.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department/")
public class DepartmentController {

    private final DepartmentServices departmentServices;

    @Autowired
    public DepartmentController(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @PostMapping(value = "addDepartment")
    public ResponseEntity<String> addDepartment(@RequestBody Department department){
        String response = departmentServices.addDepartment(department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "getAllDepartments")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentServices.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(value = "getDepartmentById")
    public ResponseEntity<Department> getDepartmentById(@RequestParam String departmentId){
        Optional<Department> department = departmentServices.getDepartmentById(departmentId);
        return department.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "getDepartmentsByName")
    public ResponseEntity<List<Department>> getDepartmentsByName(@RequestParam String departmentName){
        List<Department> departments = departmentServices.getDepartmentsByName(departmentName);
        if (!departments.isEmpty()) {
            return new ResponseEntity<>(departments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "editKeyword")
    public ResponseEntity<String> editKeyword(@RequestParam String departmentName, @RequestParam String keyword){
        String response = departmentServices.editKeyword(departmentName, keyword);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "deleteDepartment")
    public ResponseEntity<String> deleteDepartment(@RequestParam String departmentName){
        String response = departmentServices.deleteDepartment(departmentName);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "updateDepartment")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department){
        String response = departmentServices.updateDepartment(department);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
