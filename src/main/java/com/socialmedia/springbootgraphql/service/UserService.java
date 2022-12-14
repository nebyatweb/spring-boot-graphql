package com.socialmedia.springbootgraphql.service;

import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void updateUser(User user, long userId);
    void removeUser(long userId);
    User getUserById(long userId);
    List<User> getAllUsers();
    List<Post> getPosts(long userId);
}
