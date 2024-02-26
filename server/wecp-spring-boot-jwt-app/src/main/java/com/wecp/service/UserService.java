package com.wecp.service;

import java.sql.SQLException;
import java.util.List;

import com.wecp.entities.User;
 
 
public interface UserService {
    List<User> getAllUsers();
    User getUserById(long userId);
    User getUserByUserEmail(String email);
    User addUser(User user);
    void updateUser(long userId, User user);
    void deleteUser(long userId);
}
