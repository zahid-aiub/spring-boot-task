package com.ds.test.controller;

import com.ds.test.entity.Post;
import com.ds.test.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return this.postService.getAllPosts();
    }

    @GetMapping("/posts/{postId}")
    public Post getPostById(@PathVariable Long postId) {
        return this.postService.getPostById(postId);
    }

    @PostMapping("/posts")
    public Post createPost(@Valid @RequestBody Post post) {
        return this.postService.createPost(post);
    }

    @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return this.postService.updatePost(postId, postRequest);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return this.postService.deletePost(postId);
    }

}
