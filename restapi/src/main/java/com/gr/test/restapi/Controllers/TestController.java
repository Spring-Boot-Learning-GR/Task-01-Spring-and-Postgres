package com.gr.test.restapi.Controllers;

import com.gr.test.restapi.Models.TestUser;
import com.gr.test.restapi.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    public  ResponseEntity<List<TestUser>> getAllUsers() {
        return new ResponseEntity<>(testService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TestUser> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(testService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TestUser> createUser(@RequestBody TestUser testUser) {
        return new ResponseEntity<>(testService.addOrUpdateUser(testUser), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<TestUser> updateUser(@RequestBody TestUser testUser) {
        return new ResponseEntity<>(testService.addOrUpdateUser(testUser), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        testService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.NO_CONTENT);
    }
}
