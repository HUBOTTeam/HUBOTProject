package com.HUBOT.HUBOT.WorkingEmployee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingEmployeeRepository extends MongoRepository<WorkingEmployee, String> {
    WorkingEmployee findByWorkingEmployeeFirstNameAndWorkingEmployeeLastName(String firstName, String lastName);
}
