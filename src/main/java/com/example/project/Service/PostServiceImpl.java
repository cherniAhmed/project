package com.example.project.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Entity.PostUser;

import com.example.project.Reposotiry.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl  implements PostService{
    @Autowired
    private PostRepository postRepository;

    

    @Override
    public PostUser savePost(PostUser post) {
        post.setDate(new Date());
            post.setLikeCount(0);
            post.setViewCount(0);

        return postRepository.save(post);
    }

    @Override
    public List<PostUser> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostUser getPostById(Long postId) {
        Optional<PostUser> optionalpost=postRepository.findById(postId);
        if (optionalpost.isPresent()) {
            PostUser post=optionalpost.get();
            post.setViewCount(post.getViewCount()+1);
            return postRepository.save(post);

            
        }else{
            throw new EntityNotFoundException("Post not Found");
        }
    }

    @Override
    public PostUser updatePost(Long postId, PostUser postDetails) {
        Optional<PostUser> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            PostUser post = optionalPost.get();
            post.setName(postDetails.getName());
            post.setLieux(postDetails.getLieux());
            post.setTlf(postDetails.getTlf());
            post.setEmail(postDetails.getEmail());
            post.setContent(postDetails.getContent());
            post.setPostedby(postDetails.getPostedby());
            post.setTags(postDetails.getTags());
            post.setDate(new Date());
            return postRepository.save(post);
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    @Override
    public void deletePost(Long postId) {
        Optional<PostUser> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            postRepository.delete(optionalPost.get());
        } else {
            throw new EntityNotFoundException("Post not found");
        }
    }

    @Override
    public void likePost(Long postId) {
        Optional<PostUser> optionalPost=postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            PostUser post=optionalPost.get();

            post.setLikeCount(post.getLikeCount()+1);
            postRepository.save(post);
            
        }else{
            throw new EntityNotFoundException("Post not Found with id :"+postId);
        }
    }

    @Override
    public List<PostUser> searchByLieux(String lieux) {
        return postRepository.findByLieux(lieux);
    }

   

    

    
}