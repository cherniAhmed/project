package com.example.project.Controller;

import com.example.project.Entity.Association;
import com.example.project.Service.AssociationServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/associations")
public class AssociationController {

    @Autowired
    private AssociationServiceImpl associationService;

    @GetMapping
    public List<Association> getAllAssociations() {
        return associationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Association> getAssociationById(@PathVariable Long id) {
        Optional<Association> association = associationService.findById(id);
        if (association.isPresent()) {
            return ResponseEntity.ok(association.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Association createAssociation(@RequestBody Association association) {
        return associationService.save(association);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssociation(@PathVariable Long id) {
        associationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
