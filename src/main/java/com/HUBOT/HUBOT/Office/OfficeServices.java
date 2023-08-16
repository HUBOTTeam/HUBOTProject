package com.HUBOT.HUBOT.Office;

import com.HUBOT.HUBOT.Department.Department;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OfficeServices {

    private OfficeRepository officeRepository;

    public Office addOffice(Office office) {
        return officeRepository.insert(office);
    }

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOffice(String office_id) {
        return officeRepository.findById(office_id).orElse(null);
    }
    public List<Office> getOfficeByDepartment(Department department) {
        return officeRepository.findOfficeByDepartment(department);
    }

    public Office updateOfficeKeyword(String office_id, String keyword) {
        Office office = officeRepository.findById(office_id).orElse(null);
        if (office != null) {
            office.setKeyword(keyword);
             officeRepository.save(office);
             return office;
        }
            return null;
    }
    public Office deleteOffice(String officeId) {
        Office office = officeRepository.findById(officeId).orElse(null);
        if (office != null){
            officeRepository.deleteById(officeId);
            return office;
        }
        else
            return null;
    }
}