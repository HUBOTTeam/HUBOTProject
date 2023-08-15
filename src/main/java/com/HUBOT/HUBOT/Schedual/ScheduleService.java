package com.HUBOT.HUBOT.Schedual;

import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Enum.Semester;
import com.HUBOT.HUBOT.TakenCourses.TakenCourses;
import com.HUBOT.HUBOT.TakenCourses.TakenCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final TakenCoursesService takenCoursesService;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, TakenCoursesService takenCoursesService) {
        this.scheduleRepository = scheduleRepository;
        this.takenCoursesService = takenCoursesService;
    }

    public Schedule createSchedule(String studentId, Semester semester, int year) {
        Schedule existingSchedule = scheduleRepository.findByStudentIdAndSemesterAndYear(studentId, semester, year);
        if (existingSchedule == null) {
            Schedule newSchedule = new Schedule();
            newSchedule.setStudentId(studentId);
            newSchedule.setSemester(semester);
            newSchedule.setYear(year);
            return scheduleRepository.save(newSchedule);
        }
        return existingSchedule;
    }

    public Schedule addCourseToSchedule(String studentId, Course course) {
        Schedule schedule = scheduleRepository.findByStudentId(studentId);
        if (schedule == null) {
            schedule = new Schedule();
            schedule.setStudentId(studentId);
        }
        List<com.HUBOT.HUBOT.Course.Course> courses = schedule.getCourses();
        if (!courses.contains(course)) {
            courses.add(course);
        }
        return scheduleRepository.save(schedule);
    }

    public Schedule getScheduleByStudentId(String studentId, Semester semester, int year) {
        return scheduleRepository.findByStudentIdAndSemesterAndYear(studentId, semester, year);
    }

    public Schedule updateSemesterAndYear(String studentId, Semester semester, int year) {
        Schedule schedule = scheduleRepository.findByStudentId(studentId);
        if (schedule != null) {
            schedule.setSemester(semester);
            schedule.setYear(year);
            return scheduleRepository.save(schedule);
        }
        return null;
    }
    public Schedule removeSubjectFromSchedule(String studentId, Course course) {
        Schedule schedule = scheduleRepository.findByStudentId(studentId);
        if (schedule != null) {
            List<Course> courses = schedule.getCourses();
            if (courses.remove(course)) {
                return scheduleRepository.save(schedule);
            }
        }
        return null;
    }
    public Schedule transferCoursesToTakenCourses(String studentId, Semester semester, int year, double grade) {
        Schedule schedule = scheduleRepository.findByStudentIdAndSemesterAndYear(studentId, semester, year);
        if (schedule != null) {
            for (Course course : schedule.getCourses()) {
                TakenCourses takenCourse = new TakenCourses();
                takenCourse.setCourse(course);
                takenCourse.setSemester(semester);
                takenCourse.setYear(year);
                takenCourse.setGrade(grade);
                takenCoursesService.addTakenCourse(takenCourse);
            }

            // Clear the courses from the current schedule
            schedule.getCourses().clear();
            return scheduleRepository.save(schedule);
        }
        return null;
    }

}
