package com.example.project.Service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.DTO.SignupRequestDTO;
import com.example.project.DTO.UserDto;

import com.example.project.Entity.User;
import com.example.project.Entity.UserRole;
import com.example.project.Reposotiry.UserRepository;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepository userRepository;

   

public UserDto signupUser(SignupRequestDTO signupRequestDTO) {
    User user = new User();
    
    user.setNom(signupRequestDTO.getNom());
    user.setPrenom(signupRequestDTO.getPrenom());
    user.setLieux(signupRequestDTO.getLieux());
    user.setTelephone(signupRequestDTO.getTelephone());
    user.setEmail(signupRequestDTO.getEmail());
    user.setPassword(signupRequestDTO.getPassword());
    //user.setGroupSang(signupRequestDTO.getGroupsang());
    
    // Set other attributes
    user.setCin(signupRequestDTO.getCin());
    user.setSexe(signupRequestDTO.getSexe());
    user.setDateBirthday(signupRequestDTO.getDateBirthday());
    user.setRole(UserRole.USER); // Assuming UserRole is an enum
    
    // Save the user entity to the database
    User savedUser = userRepository.save(user);
    
    // Return the DTO representation of the saved user
    return savedUser.getDto(); // Assuming getDto() returns UserDto
}

public Boolean presentByEmail(String email){
    return userRepository.findFirstByEmail(email) !=null;
}

public UserDto signupAdmin(SignupRequestDTO signupRequestDTO) {
    User user = new User();
    
    user.setNom(signupRequestDTO.getNom());
    user.setPrenom(signupRequestDTO.getPrenom());
    
    user.setTelephone(signupRequestDTO.getTelephone());
    user.setEmail(signupRequestDTO.getEmail());
    user.setPassword(signupRequestDTO.getPassword());
    //user.setGroupSang(signupRequestDTO.getGroupsang());
    
    // Set other attributes
    user.setCin(signupRequestDTO.getCin());
    
    user.setRole(UserRole.ADMIN); // Assuming UserRole is an enum
    
    // Save the user entity to the database
    User savedUser = userRepository.save(user);
    
    // Return the DTO representation of the saved user
    return savedUser.getDto(); // Assuming getDto() returns UserDto
}


}