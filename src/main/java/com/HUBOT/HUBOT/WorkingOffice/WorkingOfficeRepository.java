package com.HUBOT.HUBOT.WorkingOffice;

import com.HUBOT.HUBOT.WorkingDepartment.WorkingDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkingOfficeRepository extends MongoRepository<WorkingOffice, String> {
    List<WorkingOffice> findByWorkingDepartment_WorkingDepartmentId(String workingDepartmentId);

}
