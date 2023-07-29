package com.HUBOT.HUBOT.Department;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentServices {

    private DepartmentRepositry departmentRepositry;

    public String addDepartment(Department department) {
        departmentRepositry.insert(department);
        return department.getDepartmentName()+" added successfully!!";
    }

    public List<Department> getAllDepartments() {
        return departmentRepositry.findAll();
    }

    public String editKeyword(String departmentName, String keyword) {
        Department department = departmentRepositry.findBydepartmentName(departmentName);
        department.setKeyword(keyword);
        departmentRepositry.save(department);
        return departmentName+" edited successfully!";

    }

    public String deleteDepartment(String departmentName) {
        departmentRepositry.deleteBydepartmentName(departmentName);
        return departmentName+" deleted successfully!!";
    }
}
