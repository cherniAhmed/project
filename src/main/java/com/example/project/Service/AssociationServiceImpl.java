package com.example.project.Service;

import com.example.project.Entity.Association;
import com.example.project.Reposotiry.AssociationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociationServiceImpl {

    @Autowired
    private AssociationRepository associationRepository;

    public List<Association> findAll() {
        return associationRepository.findAll();
    }

    public Optional<Association> findById(Long id) {
        return associationRepository.findById(id);
    }

    public Association save(Association association) {
        return associationRepository.save(association);
    }

    public void deleteById(Long id) {
        associationRepository.deleteById(id);
    }
}
