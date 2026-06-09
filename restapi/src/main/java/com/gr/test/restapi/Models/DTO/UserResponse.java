package com.gr.test.restapi.Models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    public int id;
    public String name;
}
