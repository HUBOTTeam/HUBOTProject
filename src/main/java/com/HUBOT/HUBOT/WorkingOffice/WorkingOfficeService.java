package com.HUBOT.HUBOT.WorkingOffice;

import com.HUBOT.HUBOT.WorkingDepartment.WorkingDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkingOfficeService {
    private final WorkingOfficeRepository workingOfficeRepository;

    @Autowired
    public WorkingOfficeService(WorkingOfficeRepository workingOfficeRepository) {
        this.workingOfficeRepository = workingOfficeRepository;
    }

    public WorkingOffice addWorkingOffice(WorkingOffice workingOffice) {
        return workingOfficeRepository.insert(workingOffice);
    }

    public List<WorkingOffice> getAllWorkingOffices() {
        return workingOfficeRepository.findAll();
    }

    public Optional<WorkingOffice> getWorkingOfficeById(String workingOfficeId) {
        return workingOfficeRepository.findById(workingOfficeId);
    }

    public List<WorkingOffice> getWorkingOfficesByWorkingDepartment(String workingDepartmentId) {
        return workingOfficeRepository.findByWorkingDepartment_WorkingDepartmentId(workingDepartmentId);
    }

    public WorkingOffice updateKeywordAndFloor(String workingOfficeId, String keyword, int floor) {
        WorkingOffice workingOffice = workingOfficeRepository.findById(workingOfficeId).orElse(null);
        if (workingOffice != null) {
            workingOffice.setKeyword(keyword);
            workingOffice.setFloor(floor);
            return workingOfficeRepository.save(workingOffice);
        } else {
            return null;
        }
    }

    public void deleteWorkingOffice(String workingOfficeId) {
        workingOfficeRepository.deleteById(workingOfficeId);
    }
}
