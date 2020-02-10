package com.ds.test.service;

import com.ds.test.entity.Comment;
import com.ds.test.exception.ResourceNotFoundException;
import com.ds.test.repository.CommentRepository;
import com.ds.test.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Comment> getAllCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Optional<Comment> getCommentByPostIdAndCommentId(Long postId, Long commentId) {
        return this.commentRepository.findByIdAndPostId(commentId, postId);
    }

    public Comment createComment(Long postId, Comment comment) {
        return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

    public Comment updateComment(Long postId, Long commentId, Comment commentRequest) {
        if (!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setText(commentRequest.getText());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    public ResponseEntity<?> deleteComment(Long postId, Long commentId) {
        return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and postId " + postId));
    }

}
