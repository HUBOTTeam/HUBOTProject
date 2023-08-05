package com.HUBOT.HUBOT.Hall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    public Hall getHallById(String hallId) {
        return hallRepository.findById(hallId).orElse(null);
    }

    public Hall addHall(Hall hall) {
        return hallRepository.insert(hall);
    }

    public Hall updateHall(Hall hall) {
        if (hall.getHallId() != null) {
            return hallRepository.save(hall);
        }
        return null;
    }

    public boolean deleteHall(String hallId) {
        Hall existingHall = hallRepository.findById(hallId).orElse(null);
        if (existingHall != null) {
            hallRepository.delete(existingHall);
            return true;
        }
        return false;
    }

    // Additional methods for filtering and updating halls

    public List<Hall> getAllHallsInBuilding(String buildingId) {
        return hallRepository.findByBuildingBuildingId(buildingId);
    }
    public List<Hall> getHallsByName(String hallName) {
        return hallRepository.findByHallName(hallName);
    }

    public List<Hall> getHallsByCapacity(int capacity) {
        return hallRepository.findByCapacity(capacity);
    }

    public Hall updateHallName(String hallId, String hallName) {
        Hall hall = hallRepository.findById(hallId).orElse(null);
        if (hall != null) {
            hall.setHallName(hallName);
            return hallRepository.save(hall);
        } else {
            return null;
        }
    }

    public Hall updateCapacity(String hallId, int capacity) {
        Hall hall = hallRepository.findById(hallId).orElse(null);
        if (hall != null) {
            hall.setCapacity(capacity);
            return hallRepository.save(hall);
        } else {
            return null;
        }
    }

    public Hall updateFloor(String hallId, int floor) {
        Hall hall = hallRepository.findById(hallId).orElse(null);
        if (hall != null) {
            hall.setFloor(floor);
            return hallRepository.save(hall);
        } else {
            return null;
        }
    }

    public Hall updateKeyword(String hallId, String keyword) {
        Hall hall = hallRepository.findById(hallId).orElse(null);
        if (hall != null) {
            hall.setKeyword(keyword);
            return hallRepository.save(hall);
        } else {
            return null;
        }
    }
}
