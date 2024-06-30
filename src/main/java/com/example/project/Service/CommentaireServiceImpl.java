package com.example.project.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.CommentairePost;
import com.example.project.Entity.PostUser;
import com.example.project.Reposotiry.CommentaireRepository;
import com.example.project.Reposotiry.PostRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class CommentaireServiceImpl implements CommentaireService{
    
    @Autowired
    private CommentaireRepository commentaireRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public CommentairePost createComment(Long postId, String content) {
        Optional<PostUser> optionalPost= postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            CommentairePost comment =new CommentairePost();
            comment.setPost(optionalPost.get()); 
            comment.setContent(content); 
           
            comment.setCreatedAt(new Date());

            return commentaireRepository.save(comment);
            
        }
        throw new EntityNotFoundException("Post Not Found");
    }
    @Override
    public List<CommentairePost> getCommentByPostId(Long postId) {
        return commentaireRepository.findByPostId(postId);
    }
    @Override
    public CommentairePost updateComment(Long commentId, String content) {
        Optional<CommentairePost> optionalComment = commentaireRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            CommentairePost comment = optionalComment.get();
            comment.setContent(content);
            comment.setUpdatedAt(new Date());
            return commentaireRepository.save(comment);
        } else {
            throw new EntityNotFoundException("Comment Not Found");
        }
    }
    @Override
    public void deleteComment(Long commentId) {
        Optional<CommentairePost> optionalComment = commentaireRepository.findById(commentId);
        if (optionalComment.isPresent()) {
            commentaireRepository.delete(optionalComment.get());
        } else {
            throw new EntityNotFoundException("Comment Not Found");
        }
    }
    
}