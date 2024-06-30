package com.example.project.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.User;
import com.example.project.Reposotiry.UserRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class UserServiceImpl implements service{
    
   @Autowired
   private  UserRepository userRepository;

   public Optional<User> getUser(Long id) {
    return userRepository.findById(id);
}

public User postUser(User user) {
    return userRepository.save(user);
}

public User updateUser(Long id, User userUpdates) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
        User existingUser = optionalUser.get();
        existingUser.setNom(userUpdates.getNom());
        existingUser.setPrenom(userUpdates.getPrenom());
        existingUser.setLieux(userUpdates.getLieux());
        existingUser.setGroupsang(userUpdates.getGroupsang());
        existingUser.setCin(userUpdates.getCin());
        existingUser.setTelephone(userUpdates.getTelephone());
        existingUser.setSexe(userUpdates.getSexe());
        existingUser.setDateBirthday(userUpdates.getDateBirthday());
        return userRepository.save(existingUser);
    } else {
        
        throw new RuntimeException("Utilisateur non trouvé avec l'ID : " + id);
        
    }
}

public void deleteUser(Long id) {
    userRepository.deleteById(id);
}

@Override
public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
}



}
