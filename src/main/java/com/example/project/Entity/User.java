package com.example.project.Entity;



import com.example.project.DTO.UserDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    

    public UserDto getDto(){
       
            UserDto userDto = new UserDto();
            userDto.setId(id);
            userDto.setNom(nom);;
            userDto.setPrenom(prenom);;
            userDto.setLieux(lieux);
            userDto.setTelephone(telephone);
            userDto.setGroupsang(groupsang);;
            userDto.setEmail(email);
            userDto.setRole(role);
            return userDto;
        }
    }
    
    
    



