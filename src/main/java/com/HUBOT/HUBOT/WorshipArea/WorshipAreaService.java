package com.HUBOT.HUBOT.WorshipArea;

import com.HUBOT.HUBOT.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorshipAreaService {
    @Autowired
    private  WorshipAreaRepository worshipAreaRepository;

    public WorshipArea addWorshipArea(WorshipArea worshipArea) {
        return worshipAreaRepository.save(worshipArea);
    }

    public WorshipArea getWorshipAreaById(String worshipAreaId) {
        return worshipAreaRepository.findById(worshipAreaId).orElse(null);
    }

    public List<WorshipArea> getWorshipAreasByBuildingId(String buildingId) {
        return worshipAreaRepository.findByBuildingBuildingId(buildingId);
    }

    public WorshipArea updateWorshipArea(WorshipArea worshipArea) {
        WorshipArea existingWorshipArea = worshipAreaRepository.findById(worshipArea.getWorshipAreaId()).orElse(null);
        if (existingWorshipArea != null) {
            return worshipAreaRepository.save(worshipArea);
        }
        return null;
    }

    public boolean deleteWorshipArea(String worshipAreaId) {
        WorshipArea existingWorshipArea = worshipAreaRepository.findById(worshipAreaId).orElse(null);
        if (existingWorshipArea != null) {
            worshipAreaRepository.delete(existingWorshipArea);
            return true;
        }
        return false;
    }

    public List<WorshipArea> getAllWorshipAreas() {
        return worshipAreaRepository.findAll();
    }
    public List<WorshipArea> getWorshipAreasByGenderAndBuilding(Gender gender, String buildingId) {
        return worshipAreaRepository.findByGenderAndBuildingBuildingId(gender, buildingId);
    }

}
