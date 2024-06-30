package com.example.project.Service.AuthService;

import com.example.project.DTO.SignupRequestDTO;
import com.example.project.DTO.UserDto;

public interface AuthService {
    UserDto signupUser(SignupRequestDTO signupRequestDTO);
    Boolean presentByEmail(String email);
    UserDto signupAdmin(SignupRequestDTO signupRequestDTO);
}