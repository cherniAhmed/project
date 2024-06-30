package com.example.project.Reposotiry;
import com.example.project.Entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopitalRepository extends JpaRepository<Hospital, Long> {
    // Vous pouvez ajouter des méthodes de requête personnalisées si nécessaire
}