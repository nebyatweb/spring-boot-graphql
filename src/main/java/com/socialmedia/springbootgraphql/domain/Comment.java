package com.socialmedia.springbootgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    private String body;
    private String username;
    private LocalDate createdAt;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "commentId")
    List<Like> likes = new ArrayList<>();

    public void addLike(Like like) {
        likes.add(like);
    }
}
