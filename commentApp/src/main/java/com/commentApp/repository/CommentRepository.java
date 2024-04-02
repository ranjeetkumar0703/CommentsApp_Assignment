package com.commentApp.repository;

import com.commentApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByUsername(String username);
    List<Comment> findByDate(Date date);
}
