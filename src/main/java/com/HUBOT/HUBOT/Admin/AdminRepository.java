package com.HUBOT.HUBOT.Admin;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository
        extends MongoRepository<Admin,String> {
    Admin findAdminByAdminUserName(String adminUserName);
    @NotNull
    Optional<Admin> findById(@NotNull String adminId);
    boolean deleteAdminByAdminUserName(String adminUserName);

}
