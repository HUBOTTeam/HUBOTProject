package com.HUBOT.HUBOT.Lab;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabService {
    private final LabRepository labRepository;

    @Autowired
    public LabService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public Lab addLab(Lab lab) {
        return labRepository.save(lab);
    }

    public Lab getLabById(String labId) {
        return labRepository.findById(labId).orElse(null);
    }

    public List<Lab> getLabsByBuildingId(String buildingId) {
        return labRepository.findByBuildingBuildingId(buildingId);
    }

    public Lab updateLab(Lab lab) {
        Lab existingLab = labRepository.findById(lab.getLabId()).orElse(null);
        if (existingLab != null) {
            return labRepository.save(lab);
        }
        return null;
    }

    public boolean deleteLab(String labId) {
        Lab existingLab = labRepository.findById(labId).orElse(null);
        if (existingLab != null) {
            labRepository.delete(existingLab);
            return true;
        }
        return false;
    }

    public List<Lab> getAllLabs() {
        return labRepository.findAll();
    }

    // Add any additional methods you need for querying Labs
}
