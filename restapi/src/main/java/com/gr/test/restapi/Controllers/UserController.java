package com.gr.test.restapi.Controllers;

import com.gr.test.restapi.Models.DTO.UserRequest;
import com.gr.test.restapi.Models.DTO.UserResponse;
import com.gr.test.restapi.Models.User;
import com.gr.test.restapi.Services.UserService;
import com.gr.test.restapi.Utils.UserMapperUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
@Valid
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public  ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers().stream().map(UserMapperUtil::toUserResponse).toList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int id) {
        return new ResponseEntity<>(UserMapperUtil.toUserResponse(userService.getUserById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(UserMapperUtil.toUserResponse(userService.addOrUpdateUser(UserMapperUtil.toUser(userRequest))), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(UserMapperUtil.toUserResponse(userService.addOrUpdateUser(UserMapperUtil.toUser(userRequest))), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.NO_CONTENT);
    }
}
