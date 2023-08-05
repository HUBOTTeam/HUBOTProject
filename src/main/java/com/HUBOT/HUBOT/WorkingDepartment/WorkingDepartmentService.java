package com.HUBOT.HUBOT.WorkingDepartment;

import com.HUBOT.HUBOT.Building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingDepartmentService {
    private final WorkingDepartmentRepository workingDepartmentRepository;

    @Autowired
    public WorkingDepartmentService(WorkingDepartmentRepository workingDepartmentRepository) {
        this.workingDepartmentRepository = workingDepartmentRepository;
    }

    public WorkingDepartment addWorkingDepartment(WorkingDepartment workingDepartment) {
        return workingDepartmentRepository.insert(workingDepartment);
    }

    public WorkingDepartment getWorkingDepartmentById(String workingDepartmentId) {
        return workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
    }

    public List<WorkingDepartment> getAllWorkingDepartments() {
        return workingDepartmentRepository.findAll();
    }


    public WorkingDepartment updateBuildingReference(String workingDepartmentId, Building building) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setBuilding(building);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }

    public WorkingDepartment updateWorkingDepartmentLocationId(String workingDepartmentId, String workingDepartmentLocationId) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setWorkingDepartmentLocationId(workingDepartmentLocationId);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }

    public WorkingDepartment updateWorkingDepartmentName(String workingDepartmentId, String workingDepartmentName) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setWorkingDepartmentName(workingDepartmentName);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }

    public WorkingDepartment updateWorkingDepartmentDescription(String workingDepartmentId, String description) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setDescription(description);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }

    public WorkingDepartment updateWorkingDepartmentKeyword(String workingDepartmentId, String keyword) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setKeyword(keyword);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }

    public WorkingDepartment updateWorkingDepartmentFloor(String workingDepartmentId, int floor) {
        WorkingDepartment workingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (workingDepartment != null) {
            workingDepartment.setFloor(floor);
            return workingDepartmentRepository.save(workingDepartment);
        } else {
            return null;
        }
    }
    public WorkingDepartment updateWorkingDepartment(WorkingDepartment workingDepartment) {
        return workingDepartmentRepository.save(workingDepartment);
    }

    public boolean deleteWorkingDepartment(String workingDepartmentId) {
        WorkingDepartment existingWorkingDepartment = workingDepartmentRepository.findById(workingDepartmentId).orElse(null);
        if (existingWorkingDepartment != null) {
            workingDepartmentRepository.delete(existingWorkingDepartment);
            return true;
        }
        return false;
    }
}
