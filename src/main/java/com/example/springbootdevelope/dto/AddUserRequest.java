package com.example.springbootdevelope.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddUserRequest {
    private  String email;
    private  String password;
}
