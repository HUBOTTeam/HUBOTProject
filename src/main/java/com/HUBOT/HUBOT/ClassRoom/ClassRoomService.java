package com.HUBOT.HUBOT.ClassRoom;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;

    @Autowired
    public ClassRoomService(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public ClassRoom addClassRoom(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    public ClassRoom getClassRoomById(int classRoomId) {
        return classRoomRepository.findById(classRoomId).orElse(null);
    }

    public List<ClassRoom> getClassRoomsByBuildingId(String buildingId) {
        return classRoomRepository.findByBuildingBuildingId(buildingId);
    }

    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        ClassRoom existingClassRoom = classRoomRepository.findById(classRoom.getClassRoomId()).orElse(null);
        if (existingClassRoom != null) {
            return classRoomRepository.save(classRoom);
        }
        return null;
    }

    public boolean deleteClassRoom(int classRoomId) {
        ClassRoom existingClassRoom = classRoomRepository.findById(classRoomId).orElse(null);
        if (existingClassRoom != null) {
            classRoomRepository.delete(existingClassRoom);
            return true;
        }
        return false;
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepository.findAll();
    }

    // Add any additional methods you need for querying ClassRooms
}
