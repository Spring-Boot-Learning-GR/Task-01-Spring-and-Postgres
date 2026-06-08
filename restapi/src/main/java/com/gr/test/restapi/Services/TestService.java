package com.gr.test.restapi.Services;

import com.gr.test.restapi.Models.TestUser;

import java.util.List;

public interface TestService {
    List<TestUser> getAllUsers();
    TestUser getUserById(int id) throws IllegalArgumentException;
    TestUser addOrUpdateUser(TestUser testUser) throws IllegalArgumentException;
    void deleteUserById(int userId) throws IllegalArgumentException;
}
