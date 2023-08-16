package com.HUBOT.HUBOT.WorkingEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingEmployeeService {

    private  WorkingEmployeeRepository workingEmployeeRepository;

    public WorkingEmployee addWorkingEmployee(WorkingEmployee workingEmployee) {
        return workingEmployeeRepository.save(workingEmployee);
    }

//    public List<WorkingEmployee> getWorkingEmployeeByWorkingDepartment(String workingDepartmentId) {
//        return workingEmployeeRepository.findAllWorkingEmployeeByWorkingDepartmentId(workingDepartmentId);
//    }

    public List<WorkingEmployee> getAllWorkingEmployees() {
        return workingEmployeeRepository.findAll();
    }

    public WorkingEmployee getWorkingEmployeeById(String workingEmployeeId) {
        return workingEmployeeRepository.findById(workingEmployeeId).orElse(null);
    }

    public WorkingEmployee getWorkingEmployeeByFullName(String firstName, String lastName) {
        return workingEmployeeRepository.findByWorkingEmployeeFirstNameAndWorkingEmployeeLastName(firstName, lastName);
    }

    public WorkingEmployee updateWorkingEmployee(WorkingEmployee workingEmployee) {
        return workingEmployeeRepository.save(workingEmployee);
    }

    public boolean deleteWorkingEmployee(String workingEmployeeId) {
        WorkingEmployee existingWorkingEmployee = workingEmployeeRepository.findById(workingEmployeeId).orElse(null);
        if (existingWorkingEmployee != null) {
            workingEmployeeRepository.delete(existingWorkingEmployee);
            return true;
        }
        return false;
    }
}
