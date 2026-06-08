package com.gr.test.restapi.Services;

import com.gr.test.restapi.Models.User;
import com.gr.test.restapi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.IllegalArgumentException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found for id " + id));
    }

    @Override
    public User addOrUpdateUser(User user) throws IllegalArgumentException {
        if(user.getId() == 0) {
            return userRepository.save(user);
        } else {
            User existingUser = getUserById(user.getId());
            existingUser.setName(user.getName());
            return userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUserById(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be greater than 0");
        }
        userRepository.deleteById(id);
    }
}
