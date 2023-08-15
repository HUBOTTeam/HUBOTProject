package com.HUBOT.HUBOT.Major;

import com.HUBOT.HUBOT.Department.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MajorRepository extends MongoRepository<Major, String> {
    List<Major> findAllByDepartment(Department department);
    Major findByMajorName(String majorName);
}
