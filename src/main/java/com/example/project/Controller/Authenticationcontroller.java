package com.example.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.DTO.SignupRequestDTO;
import com.example.project.DTO.UserDto;
import com.example.project.Service.AuthService.AuthService;

@RestController
public class Authenticationcontroller {
    @Autowired
    private AuthService authService;


    @PostMapping("/admin/sign-up")
    public ResponseEntity<?> signupAdmin(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("Admin already exists with this Email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupUser(signupRequestDTO);
        return new ResponseEntity<>(createUser, HttpStatus.OK);
    }

    @PostMapping("/user/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequestDTO signupRequestDTO) {
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("User already exists with this Email", HttpStatus.NOT_ACCEPTABLE);
        }
        UserDto createUser = authService.signupUser(signupRequestDTO);
        return new ResponseEntity<>(createUser, HttpStatus.OK);
    }
    
}