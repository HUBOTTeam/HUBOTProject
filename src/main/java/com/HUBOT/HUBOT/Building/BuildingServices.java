package com.HUBOT.HUBOT.Building;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuildingServices {

    private BuildingsRepository buildingRepository;

    @Autowired
    public BuildingServices(BuildingsRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building addBuilding(Building building) {
        return buildingRepository.insert(building);
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingByName(String buildingName) {
        return buildingRepository.findByBuildingName(buildingName);
    }

    public Building updateBuildingKeyword(String buildingName, String keyword) {
        Building building = buildingRepository.findByBuildingName(buildingName);
        if (building != null) {
            building.setKeyword(keyword);
            return buildingRepository.save(building);
        }
        return null;
    }

    public Building updateBuildingDescription(String buildingName, String description) {
        Building building = buildingRepository.findByBuildingName(buildingName);
        if (building != null) {
            building.setDescription(description);
            return buildingRepository.save(building);
        }
        return null;
    }
    public Building updateBuildingName(String buildingName, String newBuildingName) {
        Building building = buildingRepository.findByBuildingName(buildingName);
        if (building != null) {
            building.setBuildingName(newBuildingName);
            return buildingRepository.save(building);
        }
        return null;
    }

    public void deleteBuilding(String buildingName) {
        buildingRepository.deleteByBuildingName(buildingName);
    }

}
