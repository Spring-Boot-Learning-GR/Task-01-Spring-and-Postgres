package com.gr.test.restapi.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class ErrorResponse {
    int code;
    String message;
}
