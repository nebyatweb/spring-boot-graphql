package com.socialmedia.springbootgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private String body;
    private String username;
    private LocalDateTime createdAt;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "postId")
//    List<Comment> comments = new ArrayList<>();

//    public void addComment(Comment comment) {
//        comments.add(comment);
//    }
}
