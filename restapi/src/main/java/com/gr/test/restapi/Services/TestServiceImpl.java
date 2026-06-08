package com.gr.test.restapi.Services;

import com.gr.test.restapi.Models.TestUser;
import com.gr.test.restapi.Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<TestUser> getAllUsers() {
        return testRepository.findAll();
    }

    @Override
    public TestUser getUserById(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        return testRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found for id" + id));
    }

    @Override
    public TestUser addOrUpdateUser(TestUser testUser) throws IllegalArgumentException {
        if(testUser.getId() == 0) {
            return testRepository.save(testUser);
        } else {
            TestUser existingUser = getUserById(testUser.getId());
            existingUser.setName(testUser.getName());
            return testRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUserById(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        testRepository.deleteById(id);
    }
}
