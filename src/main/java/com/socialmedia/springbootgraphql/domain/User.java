package com.socialmedia.springbootgraphql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }
}
