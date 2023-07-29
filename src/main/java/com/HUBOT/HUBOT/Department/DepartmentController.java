package com.HUBOT.HUBOT.Department;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/department/")
public class DepartmentController {

    private DepartmentServices departmentServices;

    @PostMapping(value = "addDepartment")
    public String addDepartment(@RequestBody Department department){
        return departmentServices.addDepartment(department);
    }

    @GetMapping(value = "getAllDepartments")
    public List<Department> getAllDepartments(){
        return departmentServices.getAllDepartments();
    }

    @PutMapping(value = "editKeyword")
    public String editKeyword(@RequestParam String departmentName,@RequestParam String keyword){
        return departmentServices.editKeyword(departmentName,keyword);
    }

    @DeleteMapping(value = "deleteDepartment")
    public String deleteDepartment(@RequestParam String departmentName){
        return departmentServices.deleteDepartment(departmentName);
    }
}
