package com.HUBOT.HUBOT.SportArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportAreaService {
    private final SportAreaRepository sportAreaRepository;

    @Autowired
    public SportAreaService(SportAreaRepository sportAreaRepository) {
        this.sportAreaRepository = sportAreaRepository;
    }

    public SportArea addSportArea(SportArea sportArea) {
        return sportAreaRepository.insert(sportArea);
    }

    public SportArea getSportAreaById(String sportAreaId) {
        return sportAreaRepository.findById(sportAreaId).orElse(null);
    }

    public List<SportArea> getAllSportAreas() {
        return sportAreaRepository.findAll();
    }

    public SportArea updateSportArea(SportArea sportArea) {
        return sportAreaRepository.save(sportArea);
    }

    public boolean deleteSportArea(String sportAreaId) {
        SportArea existingSportArea = sportAreaRepository.findById(sportAreaId).orElse(null);
        if (existingSportArea != null) {
            sportAreaRepository.delete(existingSportArea);
            return true;
        }
        return false;
    }

    // Additional methods for filtering sport areas

    public List<SportArea> getSportAreasByBuildingId(String buildingId) {
        return sportAreaRepository.findByBuildingBuildingId(buildingId);
    }

    public List<SportArea> getSportAreasByTypeOfSport(String typeOfSport) {
        return sportAreaRepository.findByTypeOfSport(typeOfSport);
    }

    public List<SportArea> getSportAreasByName(String sportAreaName) {
        return sportAreaRepository.findBySportAreaName(sportAreaName);
    }
}
