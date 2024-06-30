package com.example.project.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Hospital;
import com.example.project.Reposotiry.HopitalRepository;

@Service
public class HopitalServiceImpl implements HopitalService{
 @Autowired
    private HopitalRepository hopitalRepository;

    @Override
    public List<Hospital> findAll() {
        return hopitalRepository.findAll();
    }

    @Override
    public Optional<Hospital> findById(Long id) {
        return hopitalRepository.findById(id);
    }

    @Override
    public Hospital save(Hospital hopital) {
        return hopitalRepository.save(hopital);
    }

    @Override
    public void deleteById(Long id) {
        hopitalRepository.deleteById(id);
    }
}