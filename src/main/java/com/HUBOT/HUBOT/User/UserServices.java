package com.HUBOT.HUBOT.User;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepositry userRepositry;

    public List<User> getAllUsers() {
        return userRepositry.findAll();
    }

    public User getUser(String userName) {
        return userRepositry.findByUserName(userName);
    }

    public String addUser(User user) {
        userRepositry.insert(user);
        return "The user "+user.getUserName()+" inserted successfully!!";
    }

    public String updateUserName(String userName, String newName) {
        User user = userRepositry.findByUserName(userName);
        user.setUserName(newName);
        userRepositry.save(user);
        return "The username updated to "+user.getUserName()+" successfully!!";
    }

    public String deleteUser(String userName) {
        User user = userRepositry.findByUserName(userName);
        userRepositry.delete(user);
        return "The user "+userName+" is deleted successfully!!";
    }
}
