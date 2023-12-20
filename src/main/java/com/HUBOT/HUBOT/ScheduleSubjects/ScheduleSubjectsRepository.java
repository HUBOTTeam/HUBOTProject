package com.HUBOT.HUBOT.ScheduleSubjects;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleSubjectsRepository extends MongoRepository<ScheduleSubjects, String> {
    List<ScheduleSubjects> findByStudentId(String studentId);
    ScheduleSubjects findByStudentIdAndCourseCourseId(String studentId, String courseId);
    void deleteByCourseCourseIdAndStudentId(String courseId, String studentId);

}
