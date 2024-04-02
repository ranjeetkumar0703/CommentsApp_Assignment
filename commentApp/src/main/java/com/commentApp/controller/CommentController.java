package com.commentApp.controller;

import com.commentApp.entity.Comment;
import com.commentApp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/search")
    public List<Comment> getCommentsByUsername(@RequestParam(required = false) String username,
                                               @RequestParam(required = false) Date date) {
        if (username != null) {
            return commentRepository.findByUsername(username);
        } else if (date != null) {
            return commentRepository.findByDate(date);
        } else {
            // Return empty list if no parameters provided
            return List.of();
        }
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        comment.setUsername(updatedComment.getUsername());
        comment.setText(updatedComment.getText());
        comment.setDate(updatedComment.getDate());
        return commentRepository.save(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
    }
}
