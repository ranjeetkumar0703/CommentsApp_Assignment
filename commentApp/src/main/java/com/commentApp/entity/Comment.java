package com.commentApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "_By")//By is reserved Keyword in MySql  only By  is not support in sql so some changes and in By and use
    private String username;

    @Column(name = "Text")
    private String text;

    @Column(name = "dateofcomment")
    private Date date;

    // Getters and setters
}
