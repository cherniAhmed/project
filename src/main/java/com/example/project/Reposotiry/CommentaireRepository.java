package com.example.project.Reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.CommentairePost;

@Repository
public interface CommentaireRepository extends JpaRepository <CommentairePost, Long>{
    List<CommentairePost> findByPostId(Long postId);
}