package com.HUBOT.HUBOT.BathRoom;

import com.HUBOT.HUBOT.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BathroomService {
    private final BathroomRepository bathroomRepository;

    @Autowired
    public BathroomService(BathroomRepository bathroomRepository) {
        this.bathroomRepository = bathroomRepository;
    }

    public Bathroom addBathroom(Bathroom bathroom) {
        return bathroomRepository.save(bathroom);
    }

    public List<Bathroom> getBathroomInBuilding(String buildingId) {
        return bathroomRepository.findByBuildingBuildingId(buildingId);
    }

    public List<Bathroom> getBathroomInBuildingByGender(String buildingName, Gender gender) {
        return bathroomRepository.findByBuildingBuildingNameAndGender(buildingName, gender);
    }

    public List<Bathroom> getAllBathrooms() {
        return bathroomRepository.findAll();
    }

    public Bathroom updateBathroom(Bathroom bathroom) {
        return bathroomRepository.save(bathroom);
    }

    public Bathroom deleteBathroom(String bathroomName) {
        Bathroom bathroom = bathroomRepository.findByKeyword(bathroomName);
        if (bathroom != null) {
            bathroomRepository.delete(bathroom);
            return bathroom;
        }
        return null;
    }
}


