package com.example.project.Reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.PostUser;

@Repository
public interface PostRepository extends JpaRepository<PostUser, Long> {
    List<PostUser> findByLieux(String lieux);
}