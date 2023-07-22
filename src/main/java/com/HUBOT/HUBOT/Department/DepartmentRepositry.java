package com.HUBOT.HUBOT.Department;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositry extends MongoRepository<Department,String> {
    Department findBydepartmentName(String departmentName);

    void deleteBydepartmentName(String departmentName);
}