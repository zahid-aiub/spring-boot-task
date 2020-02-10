package com.ds.test.service;

import com.ds.test.entity.Post;
import com.ds.test.exception.ResourceNotFoundException;
import com.ds.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepository.findById(postId).
                orElseThrow(() -> new ResourceNotFoundException("PostId : " + postId + " not found"));
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Long postId, Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId : " + postId + " not found"));
    }

    public ResponseEntity<?> deletePost(Long postId) {
        return postRepository.findById(postId).map(post -> {
            postRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}
