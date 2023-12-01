package com.HUBOT.HUBOT.Admin;


import com.HUBOT.HUBOT.Course.Course;
import com.HUBOT.HUBOT.Enum.AccessDegree;
import com.HUBOT.HUBOT.Exeption.NumberOfAdminLessThanRequiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class AdminServices {
    @Autowired
    AdminRepository adminRepository;
    public Admin addAdmin(Admin admin) {//here admin with access degree of 3 can add new admin to the system
        Admin admin1 = adminRepository.findAdminByAdminUserName(admin.getAdminUserName());
        if (admin1 != null)
        return adminRepository.insert(admin);
        else
            return null;
    }

    public Admin getAdminByUserName(String adminUserName){
        return adminRepository.findAdminByAdminUserName(adminUserName);
    }

    public Admin getAdmin(String adminId) {
        return adminRepository.findById(adminId).orElse(null);
    }

    public List<Admin> getAllAdmins(){
            return adminRepository.findAll();
    }

    public Admin editName(String adminUserName,String adminFirstName,String adminLastName) {
            Admin admin = adminRepository.findAdminByAdminUserName(adminUserName);
            if (admin != null) {
                admin.setAdminFirstName(adminFirstName);
                admin.setAdminLastName(adminLastName);
                adminRepository.save(admin);
                return admin;
            } else
                return null;

    }

//    public Admin editAdminAccessDegree(String adminUserName, AccessDegree adminAccessDegree) throws NumberOfAdminLessThanRequiredException {
//        Admin admin = adminRepository.findAdminByAdminUserName(adminUserName);
//        if (admin != null) {
//            if (adminAccessDegree != AccessDegree.FOUR) {//I want here to check that there is always at least one FOUR degree admin
//                List<Admin> admins = adminRepository.findAll();
//                int counter = 0;
//                for (Admin a : admins) {
//                    if (a.getAccessDegree() == AccessDegree.FOUR && counter < 2)
//                        counter++;
//                    else if (counter >= 2)
//                        break;
//
//                }//for each
//                if (counter >= 2){
//                    admin.setAccessDegree(adminAccessDegree);
//                    adminRepository.save(admin);
//                    return admin;
//                }
//                else
//                    throw new NumberOfAdminLessThanRequiredException("there is only one admin with FOUR access degree");
//            }//if statement
//            else{//here if admin degree you want to update is FOUR it means you dont have to worry about checking the current number of them
//                admin.setAccessDegree(adminAccessDegree);
//                adminRepository.save(admin);
//                return admin;
//            }
//        }
//        else
//            return null;
//
//    }

    public Admin editAdminPassword(String adminUserName, String password) {
            Admin admin = adminRepository.findAdminByAdminUserName(adminUserName);
            if (admin != null) {
                admin.setPassword(admin.getPassword());
                return admin;
            }
            else return null;

    }
    public void deleteAdmin(String adminUserName) {
        boolean deletedAdmin = adminRepository.deleteAdminByAdminUserName(adminUserName);
    }

}
