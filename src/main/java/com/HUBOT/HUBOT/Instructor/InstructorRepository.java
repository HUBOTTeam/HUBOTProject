package com.HUBOT.HUBOT.Instructor;

import com.HUBOT.HUBOT.Department.Department;
import com.HUBOT.HUBOT.Enum.Gender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
    List<Instructor> findByInstructorFirstNameAndInstructorLastName(String firstName, String lastName);
    List<Instructor> findByGender(Gender gender);
    List<Instructor> findInstructorByDepartment(Department department);
}
