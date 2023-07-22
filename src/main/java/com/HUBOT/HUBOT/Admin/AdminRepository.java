package com.HUBOT.HUBOT.Admin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository
        extends MongoRepository<Admin,String> {
    Admin findByAdminUserName(String adminUserName);

}
