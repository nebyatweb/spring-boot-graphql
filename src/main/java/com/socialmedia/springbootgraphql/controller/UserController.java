package com.socialmedia.springbootgraphql.controller;

import com.socialmedia.springbootgraphql.domain.Post;
import com.socialmedia.springbootgraphql.domain.User;
import com.socialmedia.springbootgraphql.dto.CreatePostInput;
import com.socialmedia.springbootgraphql.dto.CreateUserInput;
import com.socialmedia.springbootgraphql.service.PostService;
import com.socialmedia.springbootgraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(@Argument CreateUserInput input) {
        return userService.createUser(new User(
                input.getUserId(),
                input.getUsername(),
                input.getPassword(),
                input.getEmail(),
                input.getCreatedAt(),
                new ArrayList<>()));
    }

    @QueryMapping
//    @SchemaMapping(typeName = "Query", value = "allUsers")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User userById(@Argument long userId) {
        return userService.getUserById(userId);
    }

    @SchemaMapping(typeName = "User")
    public List<Post> posts(User user) {
        return userService.getPosts(user.getUserId());
    }

}
