package com.example.project.DTO;

import com.example.project.Entity.GroupeSanguin;
import com.example.project.Entity.UserRole;

import lombok.Data;
@Data
public class SignupRequestDTO {
     private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String lieux;
    private GroupeSanguin groupsang;
    private int cin;
    private int telephone;
    private String sexe;
    private String dateBirthday;
    private UserRole role;
}