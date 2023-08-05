package com.HUBOT.HUBOT.Schedual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private final ScheduleRepository schedualRepository;


    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.schedualRepository = scheduleRepository;
    }

    public Schedule addSchedule(Schedule schedule) {
        return schedualRepository.save(schedule);
    }

    public Schedule getScheduleById(String id) {
        return schedualRepository.findById(id).orElse(null);
    }

    public List<Schedule> getAllScheduals() {
        return schedualRepository.findAll();
    }

    public Schedule updateSchedual(Schedule schedual) {
        return schedualRepository.save(schedual);
    }

    public boolean deleteSchedual(String id) {
        Schedule existingSchedual = schedualRepository.findById(id).orElse(null);
        if (existingSchedual != null) {
            schedualRepository.delete(existingSchedual);
            return true;
        }
        return false;
    }

    // Additional methods for handling Schedual
}
