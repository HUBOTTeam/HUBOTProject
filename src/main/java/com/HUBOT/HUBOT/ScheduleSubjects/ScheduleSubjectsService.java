package com.HUBOT.HUBOT.ScheduleSubjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleSubjectsService {

    private final ScheduleSubjectsRepository scheduleSubjectsRepository;

    @Autowired
    public ScheduleSubjectsService(ScheduleSubjectsRepository scheduleSubjectsRepository) {
        this.scheduleSubjectsRepository = scheduleSubjectsRepository;
    }

    public ScheduleSubjects addSubject(ScheduleSubjects scheduleSubjects) {
        ScheduleSubjects scheduleSubjects1 = scheduleSubjectsRepository.findByStudentIdAndCourseCourseId
                (scheduleSubjects.getStudent().getId(), scheduleSubjects.getCourse().getCourseId());
        if (scheduleSubjects1 == null)
            return scheduleSubjectsRepository.insert(scheduleSubjects);
        else
            return null;
    }

    public List<ScheduleSubjects> getSubjectsForStudent(String studentId) {
        return scheduleSubjectsRepository.findByStudentId(studentId);
    }

    public ScheduleSubjects removeSubject(String subjectId,String studentId) {
        return scheduleSubjectsRepository.deleteBySubjectIdAndStudentId(subjectId,studentId);
    }


}