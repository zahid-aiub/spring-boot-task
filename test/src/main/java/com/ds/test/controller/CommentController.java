package com.ds.test.controller;

import com.ds.test.entity.Comment;
import com.ds.test.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/posts/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        return this.commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public Optional<Comment> getCommentByPostIdAndCommentId(@PathVariable Long postId, @PathVariable Long commentId) {
        return this.commentService.getCommentByPostIdAndCommentId(commentId, postId);
    }

    @PostMapping("/posts/{postId}/comments")
    public Comment createComment(@PathVariable(value = "postId") Long postId,
                                 @Valid @RequestBody Comment comment) {
        return this.commentService.createComment(postId, comment);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable(value = "postId") Long postId,
                                 @PathVariable(value = "commentId") Long commentId,
                                 @Valid @RequestBody Comment commentRequest) {
        return this.commentService.updateComment(postId, commentId, commentRequest);
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable(value = "postId") Long postId,
                                           @PathVariable(value = "commentId") Long commentId) {
        return this.commentService.deleteComment(postId, commentId);
    }

}
