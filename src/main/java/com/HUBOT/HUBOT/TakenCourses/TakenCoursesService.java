package com.HUBOT.HUBOT.TakenCourses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakenCoursesService {

    private final TakenCoursesRepository takenCoursesRepository;

    @Autowired
    public TakenCoursesService(TakenCoursesRepository takenCoursesRepository) {
        this.takenCoursesRepository = takenCoursesRepository;
    }

    public TakenCourses addTakenCourse(TakenCourses takenCourse) {
        return takenCoursesRepository.save(takenCourse);
    }
}
