package com.HUBOT.HUBOT.WorkingDepartment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingDepartmentRepository extends MongoRepository<WorkingDepartment, String> {
    WorkingDepartment findByWorkingDepartmentName(String workingDepartmentName);
}
