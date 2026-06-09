package com.gr.test.restapi.Models.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Valid
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Name should not be blank")
    public String name;
}
