package com.gr.test.restapi.Services;

import com.gr.test.restapi.Models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id) throws IllegalArgumentException;
    User addOrUpdateUser(User user) throws IllegalArgumentException;
    void deleteUserById(int userId) throws IllegalArgumentException;
}
