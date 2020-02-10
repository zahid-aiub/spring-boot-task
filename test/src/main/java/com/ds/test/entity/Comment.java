package com.ds.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Post post;

    /*@OneToMany()
    private List<SubComment> subComment;*/

    public Comment() {

    }

    public Comment(String text, Post post/*, List<SubComment> subComment*/) {
        this.text = text;
        this.post = post;
//        this.subComment = subComment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

/*    public List<SubComment> getSubComment() {
        return subComment;
    }

    public void setSubComment(List<SubComment> subComment) {
        this.subComment = subComment;
    }*/

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", post=" + post +
//                ", subComment=" + subComment +
                '}';
    }
}