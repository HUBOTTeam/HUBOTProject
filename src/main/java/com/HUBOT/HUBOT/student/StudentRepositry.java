package com.HUBOT.HUBOT.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepositry extends MongoRepository<Student,String> {

    Student findByUserId(String id);

    List<Student> findByDepartmentDepartmentId(String departmentId);

}