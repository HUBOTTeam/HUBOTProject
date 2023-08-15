package com.HUBOT.HUBOT.Department;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findByDepartmentName(String departmentName);
    List<Department>findDepartmentsByFaculty(String departmentName,String facultyId);
}
