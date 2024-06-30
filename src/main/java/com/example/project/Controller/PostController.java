package com.example.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project.Entity.PostUser;
import com.example.project.Service.PostService;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/posts") 
@CrossOrigin(origins = "http://localhost:4200") 
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<PostUser> createPost(@RequestBody PostUser post) {
        try {
            PostUser createdPost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PostUser>> getAllPosts() {
        try {
            List<PostUser> posts = postService.getAllPosts();
            return ResponseEntity.status(HttpStatus.OK).body(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostUser> getPostById(@PathVariable Long postId) {
        try {
            PostUser post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{postId}/like")
    public ResponseEntity<String[]> likePost(@PathVariable Long postId) {
        try {
            postService.likePost(postId);
            return ResponseEntity.ok(new String[] { "Post liked successfully" });
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String[] { "Post not found" });
        }
    }

    @GetMapping("/search/{lieux}")
    public ResponseEntity<List<PostUser>> searchByLieux(@PathVariable String lieux) {
        try {
            List<PostUser> posts = postService.searchByLieux(lieux);
            return ResponseEntity.status(HttpStatus.OK).body(posts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostUser> updatePost(@PathVariable Long postId, @RequestBody PostUser postDetails) {
        try {
            PostUser updatedPost = postService.updatePost(postId, postDetails);
            return ResponseEntity.ok(updatedPost);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String[]> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok(new String[] { "Post deleted successfully" });
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String[] { "Post not found" });
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
