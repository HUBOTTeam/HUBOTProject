package com.HUBOT.HUBOT.Lab;

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

    // Add a new lab with lab number uniqueness check
    public Lab addLab(Lab lab) {
        // Check if the lab number is unique within the building
        if (isLabNumberUniqueInBuilding(lab.getBuilding().getBuildingId(), lab.getLabNumber())) {
            return labRepository.insert(lab);
        } else {
            // Lab number is not unique, handle this conflict (e.g., throw an exception or return null)
            // For simplicity, we will return null here
            return null;
        }
    }

    // Get a lab by its ID
    public Lab getLabById(String labId) {
        return labRepository.findById(labId).orElse(null);
    }

    // Get all labs in a building by building ID
    public List<Lab> getLabsByBuildingId(String buildingId) {
        return labRepository.findByBuildingBuildingId(buildingId);
    }

    // Get labs by building ID and lab number
    public List<Lab> getLabsByBuildingIdAndLabNumber(String buildingId, int labNumber) {
        return labRepository.findByBuildingBuildingIdAndLabNumber(buildingId, labNumber);
    }

    // Get all labs
    public List<Lab> getAllLabs() {
        return labRepository.findAll();
    }
    public Lab updateLabCategory(String labId, String category) {
        Lab lab = labRepository.findById(labId).orElse(null);
        if (lab != null) {
            lab.setCategory(category);
            return labRepository.save(lab);
        } else {
            return null;
        }
    }

    public Lab updateLabKeyword(String labId, String keyword) {
        Lab lab = labRepository.findById(labId).orElse(null);
        if (lab != null) {
            lab.setKeyword(keyword);
            return labRepository.save(lab);
        } else {
            return null;
        }
    }

    public Lab updateLabLocationId(String labId, int labLocationId) {
        Lab lab = labRepository.findById(labId).orElse(null);
        if (lab != null) {
            lab.setLabLocationId(labLocationId);
            return labRepository.save(lab);
        } else {
            return null;
        }
    }

    public Lab updateLabFloor(String labId, int floor) {
        Lab lab = labRepository.findById(labId).orElse(null);
        if (lab != null) {
            lab.setFloor(floor);
            return labRepository.save(lab);
        } else {
            return null;
        }
    }
    // Update a lab with lab number uniqueness check
    public Lab updateLab(Lab lab) {
        String labId = lab.getLabId();
        if (labId != null) {
            Lab existingLab = labRepository.findById(labId).orElse(null);
            if (existingLab != null) {
                // Check if the lab number is unique within the building (excluding the current lab)
                if (isLabNumberUniqueInBuildingExcludingCurrentLab(lab.getBuilding().getBuildingId(), lab.getLabNumber(), labId)) {
                    return labRepository.save(lab);
                } else {
                    // Lab number is not unique, handle this conflict (e.g., throw an exception or return null)
                    // For simplicity, we will return null here
                    return null;
                }
            } else {
                // Lab with the given labId does not exist, handle this scenario appropriately
                // For example, you can throw an exception or return null
                return null;
            }
        } else {
            // LabId is null, handle this scenario appropriately (e.g., throw an exception or return null)
            return null;
        }
    }


    // Delete a lab by its ID
    public boolean deleteLab(String labId) {
        Lab existingLab = labRepository.findById(labId).orElse(null);
        if (existingLab != null) {
            labRepository.delete(existingLab);
            return true;
        }
        return false;
    }

    // Helper methods to check lab number uniqueness
    private boolean isLabNumberUniqueInBuilding(String buildingId, int labNumber) {
        return labRepository.findByBuildingBuildingIdAndLabNumber(buildingId, labNumber).isEmpty();
    }

    private boolean isLabNumberUniqueInBuildingExcludingCurrentLab(String buildingId, int labNumber, String currentLabId) {
        List<Lab> labsWithSameNumberExcludingCurrentLab = labRepository.findByBuildingBuildingIdAndLabNumber(buildingId, labNumber);

        if (labsWithSameNumberExcludingCurrentLab.isEmpty()) {
            // No other labs with the same lab number, so it's unique
            return true;
        } else {
            // Check if any lab other than the current lab has the same lab number
            return labsWithSameNumberExcludingCurrentLab.stream()
                    .anyMatch(lab -> !lab.getLabId().equals(currentLabId));
        }
    }

}

