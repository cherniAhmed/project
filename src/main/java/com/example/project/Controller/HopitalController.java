package com.example.project.Controller;

import com.example.project.Entity.Hospital;
import com.example.project.Service.HopitalServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hopitaux")
public class HopitalController {

    @Autowired
    private HopitalServiceImpl hopitalService;

    @GetMapping
    public List<Hospital> getAllHopitaux() {
        return hopitalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHopitalById(@PathVariable Long id) {
        Optional<Hospital> hopital = hopitalService.findById(id);
        if (hopital.isPresent()) {
            return ResponseEntity.ok(hopital.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Hospital createHopital(@RequestBody Hospital hopital) {
        return hopitalService.save(hopital);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHopital(@PathVariable Long id) {
        hopitalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}