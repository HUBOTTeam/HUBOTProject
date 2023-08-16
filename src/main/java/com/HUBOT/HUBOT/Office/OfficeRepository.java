package com.HUBOT.HUBOT.Office;

import com.HUBOT.HUBOT.Department.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends MongoRepository<Office,String> {
    List<Office> findOfficeByDepartment(Department department);
}
