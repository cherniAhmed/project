package com.example.project.Service;

import java.util.List;
import java.util.Optional;
import com.example.project.Entity.Hospital;
public interface HopitalService {

    List<Hospital> findAll();

    Optional<Hospital> findById(Long id);

    Hospital save(Hospital hopital);

    void deleteById(Long id);

}