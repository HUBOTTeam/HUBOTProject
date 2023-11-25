package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Enum.Semester;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    Schedule findByStudentId(String studentId);
    //Schedule findByStudentId/*AndSemesterAndYear*/(String studentId/*, Semester semester, int year*/);

}
