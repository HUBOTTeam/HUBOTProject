package com.HUBOT.HUBOT.Office;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OfficeServices {

    private OfficeRepositry officeRepositry;

    public Office addOffice(Office office) {
        return officeRepositry.insert(office);
    }

    public List<Office> getAllOffices() {
        return officeRepositry.findAll();
    }

    public Office getOffice(String office_id) {
        return officeRepositry.findById(office_id).orElse(null);
    }

    public Office updateOfficeKeyword(String office_id, String keyword) {
        Office office = officeRepositry.findById(office_id).orElse(null);
        office.setKeyword(keyword);
        return officeRepositry.save(office);
    }
    public ResponseEntity<String> deleteOffice(String officeId) {
        if (officeRepositry.existsById(officeId)) {
            officeRepositry.deleteById(officeId);
            return new ResponseEntity<>("Office deleted successfully!", HttpStatus.OK);
        }
            return new ResponseEntity<>("Deletion Error!!",HttpStatus.NOT_FOUND);
    }
}
