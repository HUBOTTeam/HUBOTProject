package com.HUBOT.HUBOT.WorkingEmployee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingEmployeeRepository extends MongoRepository<WorkingEmployee, String> {
    WorkingEmployee findByWorkingEmployeeFirstNameAndWorkingEmployeeLastName(String firstName, String lastName);
    //List<WorkingEmployee> findAllWorkingEmployeeByWorkingDepartmentId(String workingDepartmentId);
}
