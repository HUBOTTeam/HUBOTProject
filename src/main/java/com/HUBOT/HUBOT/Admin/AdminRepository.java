package com.HUBOT.HUBOT.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository
        extends MongoRepository<Admin,String> {
    Admin findAdminByAdminUserName(String adminUserName);
    Admin deleteAdminByAdminUserName(String adminUserName);

}
