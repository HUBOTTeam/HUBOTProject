package com.HUBOT.HUBOT.Major;

import com.HUBOT.HUBOT.Department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    private final MajorRepository majorRepository;

    @Autowired
    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public Major addMajor(Major major) {
        return majorRepository.save(major);
    }

    public boolean deleteMajor(String majorId) {
        Major existingMajor = majorRepository.findById(majorId).orElse(null);
        if (existingMajor != null) {
            majorRepository.delete(existingMajor);
            return true;
        }
        return false;
    }

    public Major getMajorByName(String majorName) {
        return majorRepository.findByMajorName(majorName);
    }

    public List<Major> getAllMajorByDepartment(Department department) {
        return majorRepository.findAllByDepartment(department);
    }

    public List<Major> getAllMajor() {
        return majorRepository.findAll();
    }

    // Add more methods as needed...
}
