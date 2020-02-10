package com.ds.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sub-comments")
public class SubComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    String text;

/*    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "comment_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Comment comment;*/

    public SubComment() {

    }

    public SubComment( String text/*, Comment comment*/) {
        this.text = text;
//        this.comment = comment;
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

/*    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }*/

    @Override
    public String toString() {
        return "SubComment{" +
                "id=" + id +
                ", text='" + text + '\'' +
//                ", comment=" + comment +
                '}';
    }
}
