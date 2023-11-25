package com.HUBOT.HUBOT.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServices {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServices(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);

    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(String departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public List<Department> getDepartmentsByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public List<Department> getDepartmentsByFaculty(String facultyId) {
        return departmentRepository.findDepartmentsByFaculty(facultyId);

    }


    public String editKeyword(String departmentName, String keyword) {
        List<Department> departments = departmentRepository.findByDepartmentName(departmentName);
        if (!departments.isEmpty()) {
            Department department = departments.get(0);
            department.setKeyword(keyword);
            departmentRepository.save(department);
            return "Keyword updated successfully.";
        }
        return "Department not found.";
    }

    public String deleteDepartment(String departmentName) {
        List<Department> departments = departmentRepository.findByDepartmentName(departmentName);
        if (!departments.isEmpty()) {
            departmentRepository.delete(departments.get(0));
            return "Department deleted successfully.";
        }
        return "Department not found.";
    }

    public String updateDepartment(Department department) {
        departmentRepository.save(department);
        return "Department updated successfully.";
    }

}