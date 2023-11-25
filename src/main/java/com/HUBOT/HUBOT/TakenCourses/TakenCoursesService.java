package com.HUBOT.HUBOT.TakenCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakenCoursesService {

    private final TakenCoursesRepository takenCoursesRepository;

    @Autowired
    public TakenCoursesService(TakenCoursesRepository takenCoursesRepository) {
        this.takenCoursesRepository = takenCoursesRepository;
    }

    public TakenCourses addTakenCourse(TakenCourses takenCourse) {
        TakenCourses courses = takenCoursesRepository.findByCourseCourseNumber(takenCourse.getCourse().getCourseNumber());
        if(courses == null)
        return takenCoursesRepository.save(takenCourse);
        else
            return null;
    }

    public List<TakenCourses> getAllTakenCoursesOfStudent(String studentId) {
        List<TakenCourses> takenCourses = takenCoursesRepository.findByStudentId(studentId);
        if (!takenCourses.isEmpty()){
            return takenCourses;
        }
        else
            return null;
    }
}
