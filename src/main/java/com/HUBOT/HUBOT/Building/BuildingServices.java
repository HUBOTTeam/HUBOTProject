package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServices {

    private final BuildingRepository buildingRepository;

    public BuildingServices(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public String addBuilding(Building building) {
        buildingRepository.insert(building);
        return "The building " + building.getBuildingName() + " was inserted successfully!";
    }

    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    public Building getBuildingByName(String buildingName) {
        return buildingRepository.findByBuildingName(buildingName);
    }

    public String updateBuildingKeyword(String buildingName, String keyword) {
        Building building = buildingRepository.findByBuildingName(buildingName);
        building.setKeyword(keyword);
        buildingRepository.save(building);
        return buildingName + " was updated successfully!";
    }

    public String deleteBuilding(String buildingName) {
        buildingRepository.deleteByBuildingName(buildingName);
        return buildingName + " deleted successfully!";
    }
}