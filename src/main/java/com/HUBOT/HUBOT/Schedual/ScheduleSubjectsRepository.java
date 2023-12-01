package com.HUBOT.HUBOT.Schedual;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleSubjectsRepository extends MongoRepository<ScheduleSubjects, String> {
    List<ScheduleSubjects> findByStudentId(String studentId);
    ScheduleSubjects findByStudentIdAndCourseCourseId(String studentId, String courseId);
    ScheduleSubjects deleteBySubjectIdAndStudentId(String subjectId,String studentId);

}
