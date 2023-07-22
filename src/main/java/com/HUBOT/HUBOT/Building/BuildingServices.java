package com.HUBOT.HUBOT.Building;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BuildingServices {

    private BuildingsRepository buildingRepositry;

    public String addBuilding(Building building) {
        buildingRepositry.insert(building);
        return "The building "+building.getBuildingName()+" was inserted successfully!!";
    }

    public List<Building> getAllBuildings() {
        return buildingRepositry.findAll();
    }
    public Building getBuilding(String buildingName){
        Building building = buildingRepositry.findByBuildingName(buildingName);
        if(building != null){
            return buildingRepositry.findByBuildingName(buildingName);
        }
        else
            return null;
    }
    public String updateBuildingKeyword(String buildingName, String keyword) {
        Building building = buildingRepositry.findByBuildingName(buildingName);
        building.setKeyword(keyword);
        buildingRepositry.save(building);
        return buildingName+" was updated successfully!!";
    }

    public String deleteBuilding(String buildingName) {
        buildingRepositry.deleteByBuildingName(buildingName);
        return buildingName+" deleted successfully!!";
    }
}