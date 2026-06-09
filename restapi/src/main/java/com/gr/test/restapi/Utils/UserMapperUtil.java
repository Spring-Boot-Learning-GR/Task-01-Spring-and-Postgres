package com.gr.test.restapi.Utils;

import com.gr.test.restapi.Models.DTO.UserRequest;
import com.gr.test.restapi.Models.DTO.UserResponse;
import com.gr.test.restapi.Models.User;

public class UserMapperUtil {
    public static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName());
    }

    public static User toUser(UserRequest userRequest) {
        return new User(userRequest.getName());
    }
}
